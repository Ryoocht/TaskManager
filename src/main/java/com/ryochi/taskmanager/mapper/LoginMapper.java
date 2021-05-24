package com.ryochi.taskmanager.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ryochi.taskmanager.entities.Account;

@Mapper
public interface LoginMapper {
	//Get name and password from user_login(DB)
	public Account findAccount(String name);
}
