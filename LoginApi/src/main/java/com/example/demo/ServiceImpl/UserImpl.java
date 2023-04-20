package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFound;
import com.example.demo.Module.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	UserRepo repo;
	
	@Override
	public User adduser(User u) {
		return repo.save(u);
		
	}

	@Override
	public Object login(String UsernameOrEmail, String password) {
     User u = repo.findByUsernameorEmail(UsernameOrEmail, UsernameOrEmail);
     if(u!=null) {
    	 if(password.equals(u.getPassword())) {
    		 return u;
    	 }
    	 else {
    		 try {
				throw new ResourceNotFound("User", "UsernameorEmail", UsernameOrEmail);
			} catch (ResourceNotFound e) {
              return e.getMessage();
			}
    	 }
     }
     else {
		 try {
			throw new ResourceNotFound("User", "UsernameorEmail", UsernameOrEmail);
		} catch (ResourceNotFound e) {
          return e.getMessage();
		}
     }
	}

}
