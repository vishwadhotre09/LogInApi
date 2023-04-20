package com.example.demo.Service;


import com.example.demo.Module.User;


public interface UserService {

	User adduser(User u);
	
	Object login(String UsernameOrEmail, String password);
}
