package com.ryochi.taskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryochi.taskmanager.entities.MemberRegistration;
import com.ryochi.taskmanager.mapper.RegisterMemberMapper;

@Service
@Transactional
public class RegisterMemberService {
	
    @Autowired
    RegisterMemberMapper registerMemberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    //Hashing a password and insert it into DB
    public void registermemeber(MemberRegistration entity) {
    	entity.setPassword(passwordEncoder.encode(entity.getPassword()));
    	registerMemberMapper.insertMemberInfo(entity);
    }
}
