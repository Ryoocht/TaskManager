package com.ryochi.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryochi.taskmanager.entities.Todo;
import com.ryochi.taskmanager.mapper.TodoMapper;

@Controller
public class TodoController {
	
	@Autowired
	TodoMapper todoMapper;
	
	@GetMapping(value="/")
	public String showTodoPage(Model model) {
		List<Todo> incompletedList = todoMapper.selectIncomplete();
		List<Todo> completedList = todoMapper.selectComplete();
		model.addAttribute("incompletedList", incompletedList);
		model.addAttribute("completedList", completedList);
		return "todo";
	}
	
	@PostMapping(value="/add")
	public String add(Todo todo) {
		todoMapper.add(todo);
		return "redirect:/";
	}
	
    @PostMapping(value="/update")
    @ResponseBody
    public void update(Todo todo) {
        todoMapper.update(todo);
    }
	
	@PostMapping(value="/delete")
	public String delete() {
		todoMapper.delete();
		return "redirect:/";
	}
}
