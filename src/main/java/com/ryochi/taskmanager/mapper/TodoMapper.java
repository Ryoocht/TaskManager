package com.ryochi.taskmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ryochi.taskmanager.entities.Todo;

@Mapper
public interface TodoMapper {
	public List<Todo> selectIncomplete();
	
	public List<Todo> selectComplete();
	
	public void add(Todo todo);
	
	public void update(Todo todo);
	
	public void delete();
}
