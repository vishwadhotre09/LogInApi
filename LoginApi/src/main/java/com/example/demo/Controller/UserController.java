package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Module.User;
import com.example.demo.Service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService s;
	
	@PostMapping("/saveuser")
	ResponseEntity<User> saveuser(@RequestBody User u){
		return new ResponseEntity<User>(s.adduser(u), HttpStatus.CREATED);  
	}
	
	@GetMapping("/login")
	ResponseEntity<Object> login(@RequestHeader String UsernameOrEmail, @RequestHeader String password){
		Object o = s.login(UsernameOrEmail, password);
	if(o instanceof User) {
		return ResponseEntity.status(200).body(s.login(UsernameOrEmail, password));
			} 
	return ResponseEntity.status(500).body(s.login(UsernameOrEmail, password)); 
	}
}
