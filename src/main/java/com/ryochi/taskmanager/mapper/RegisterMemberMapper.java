package com.ryochi.taskmanager.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ryochi.taskmanager.entities.MemberRegistration;

@Mapper
public interface RegisterMemberMapper {
	//Insert user info into user_login(DB)
	public void insertMemberInfo(MemberRegistration entity);
}
