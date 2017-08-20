package com.mertaydar.emw.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.mertaydar.emw.entity.User;
import com.mertaydar.emw.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService Userservice;
	@GetMapping("User/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User User = Userservice.getUserById(id);
		return new ResponseEntity<User>(User, HttpStatus.OK);
	}
	@GetMapping("Users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = Userservice.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	@PostMapping("User")
	public ResponseEntity<Void> addUser(@RequestBody User User, UriComponentsBuilder builder) {
                boolean flag = Userservice.addUser(User);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/User/{id}").buildAndExpand(User.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("User")
	public ResponseEntity<User> updateUser(@RequestBody User User) {
		Userservice.updateUser(User);
		return new ResponseEntity<User>(User, HttpStatus.OK);
	}
	@DeleteMapping("User/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		Userservice.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}  