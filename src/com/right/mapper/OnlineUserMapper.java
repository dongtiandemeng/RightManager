package com.right.mapper;

import java.util.Date;

public interface OnlineUserMapper {
	public void insertOnlineUser(String username,Date onlineTime);
	public OnlineUser selectOnlineUser(String username);
	public void deleteOnlineUser(String username);
}
