package com.ryochi.taskmanager.entities;

import lombok.Data;

@Data
public class Todo {
	private int id;
	private String title;
	private int done_flag;
	private String due_date;
}
