package com.springboot.junitmockito.springjunit.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.springboot.junitmockito.springjunit.service.TodoService;

public class TodoBusinessImpl {

	private TodoService todoService;
	
	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user) {
		
		List<String> filteredTodos = new ArrayList<>(); 
		List<String> todos = todoService.retrieveTodos(user);
		
		for(String todo : todos) {
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String user) {
		
		List<String> todos = todoService.retrieveTodos(user);
		for(String todo : todos) {
			if(!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}
