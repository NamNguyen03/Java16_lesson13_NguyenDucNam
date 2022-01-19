package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import models.User;

public class UserService {
	private List<User> users;
	private static UserService instance = null;
	
	private UserService() {
		users = new ArrayList<>();
		users.add(new User("nam@gmail.com", "123456", "Nguyễn Đức Nam", "09863332563"));
	}
	
	public static UserService init() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public boolean saveUser(User user) {	
		if(existByEmail(user.getEmail())) {
			return false;
		}
		
		users.add(user);
		return true;
	}
	
	public boolean existByEmail(String email) {
		for(User u : users) {
			if(u.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	public Optional<User> login(String email, String password) {
		return users.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst();
	}
}
