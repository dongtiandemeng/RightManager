package com.right.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.chen.HelloLog4j;
import com.opensymphony.xwork2.ActionSupport;
import com.right.common.MySqlSession;
import com.right.dao.DictDao;
import com.right.dao.RoleDao;
import com.right.mapper.Menu;
import com.right.mapper.Role;

public class RoleAction extends ActionSupport{
	private static Logger logger = Logger.getLogger(HelloLog4j.class);
	List<Role> listRole;
	List<Menu> menuList;
	
	Role role;
	Integer id;
	
	List<Integer> menu; 
	
	List<Menu> restMenu = new ArrayList<Menu>();
	
	public List<Menu> getRestMenu() {
		return restMenu;
	}

	public void setRestMenu(List<Menu> restMenu) {
		this.restMenu = restMenu;
	}

	public List<Integer> getMenu() {
		return menu;
	}

	public void setMenu(List<Integer> menu) {
		this.menu = menu;
	}
	private List<Integer> chk_id;
	

	public List<Integer> getChk_id() {
		return chk_id;
	}

	public void setChk_id(List<Integer> chk_id) {
		this.chk_id = chk_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

	public RoleAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() throws Exception {
		try {
			RoleDao roleDao = new RoleDao();
			listRole = roleDao.selectRole();
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String insert(){
		
		try {
			RoleDao rDao = new RoleDao();
			menuList = rDao.selectAllMenu();
			return "insert";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySqlSession.rollback();
		}
		
		return null;
	}
	
	public String save() throws Exception{
		
		try {
			RoleDao rDao  = new RoleDao();
			int role_id=rDao.save(role);
			
//		
			//那么插入的时候就不只是插入一个表格，还有t_base_role_menu,而且不只是
//		插入一个一列，可以是多列的插入
//		logger.info("RoleAction save role_id");
//		logger.info(id);//没有id，这个好像是自动生成的
			//当然如果添加了一个role,去查他的id然后添加，当然可以做到。
			//只是看看有没有更简单的方法可以做到
//		logger.info("RoleAction save menu");
//		logger.info(menu);
					
			//中间要去查t_base_role_menu中id
			rDao.addRoleMenu(role_id,menu);
			MySqlSession.commit();
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String modify() throws Exception{
		try {
			RoleDao rDao = new RoleDao();
			role=rDao.getRoleByID(id);
			
			//这里需要拿他已经选择了menu，也要拿他没有选择的menu
			//传一个id为参数，就可以返回一个List<Menu>的集合
			
			//难道我要查t_base_role_menu返回一个Menu，其中role_id和menu_id
			//再通过一个集合List<menu>查t_base_menu，得到菜单的名字
//			menuList = rDao.selectAllMenuByRoleId(id);
//			logger.info("RoleAction modify menuList");
//			logger.info(menuList);
//			for(Menu menu:menuList){
//				logger.info("menu name="+menu.getName());
//			}
			
//			menuList = rDao.selectRestMenu(ids);//这个主要是为了那些原来没有添加role管理菜单添加数据
			//这里我原来想的是使用一个已经传递查询了t_base_role_menu的返回结果，一个List<Integer> menu_id作为参数传递。就不会导致重复出现菜单
			//在role_modify有2个集合，会出现重复
			
			//1、是否可以通过一个role_id然后就可以查t_base_role_menu得到结果ids，
			//然后就通过ids这个结果查t_base_menu得到menu的name集合
			//结果ids是在xml文件 中使用
			
			//2、结果ids是在Java代码中得到并且使用
			
			//不知道role被设置了2次，值是否存在，肯定不存在了
			//直接查菜单那个表，会出现重复，再查t_base_role_menu，role却出现了2次,值被覆盖
			//直接role再添加一个菜单的结合，存放没有被选中的菜单的名字，不过不知道role被覆盖了没有
			
//			restMenu = rDao.selectRestMenu(id);
			
			menuList=rDao.selectAllMenu();
			
			for (Menu menu : menuList) {
				int countNoSame=0;
				for (Menu roleMenu : role.getListMenu()) {
					if(roleMenu!=null&&menu.getName()!=null){
						if(roleMenu.getName().equals(menu.getName())){
							countNoSame++;
						}
					}
				}
				if(countNoSame==0){					
					restMenu.add(menu);
				}
			}
			return "modify";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String update() throws Exception{

		
		RoleDao rDao = new RoleDao();
		rDao.update(role);
		//还要更新原来的t_base_role_menu
		//如果原来有就更新，如果原来没有就插入
		
		//如果这次的集合中menu_id 没有，就把那个数据库t_base_role_menu中列删除
		//如果这次集合中有menu_id，但是数据库t_base_role_menu中没有，就添加
		//如果这次集合中有menu_id,但是数据库t_base_role_menu中有，就不添加，也不删除
		
		//这样太复杂了，还不如直接将所有的role_id的列删除，然后再重新添加
		
		
		rDao.addRoleMenu(role.getId(),menu);
		MySqlSession.commit();
		return "ok";
	}
	
	public String redirectRoleDelete(){
		return "delete";
	}
	public String delete() throws Exception{
		RoleDao rDao = new RoleDao();
		rDao.batchDelete(chk_id);
		//这里要删除掉t_base_role_menu中chk_id的列
		//可能这里的删除有点不同，因为是参数是一个集合，删除直接删除掉
		MySqlSession.commit();
		return "ok";

	}
}
