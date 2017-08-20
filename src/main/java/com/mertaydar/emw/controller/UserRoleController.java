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
import com.mertaydar.emw.entity.UserRole;
import com.mertaydar.emw.service.IUserRoleService;

@Controller
public class UserRoleController {

	@Autowired
	private IUserRoleService userRoleService;

	@GetMapping("UserRole/{id}")
	public ResponseEntity<List<UserRole>> getUserRolesById(@PathVariable("id") Integer userId) {

		List<UserRole> userRoles = userRoleService.getUserRoles(userId);

		return new ResponseEntity<List<UserRole>>(userRoles, HttpStatus.OK);
	}

//	@GetMapping("Users")
//	public ResponseEntity<List<User>> getAllUsers() {
//
//		List<User> list = userRoleService.getAllUsers();
//
//		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
//	}
//
//	@PostMapping("User")
//	public ResponseEntity<Void> addUser(@RequestBody User User, UriComponentsBuilder builder) {
//
//		boolean flag = userRoleService.addUser(User);
//
//		if (flag == false) {
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/User/{id}").buildAndExpand(User.getId()).toUri());
//
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}
//
//	@PutMapping("User")
//	public ResponseEntity<User> updateUser(@RequestBody User User) {
//
//		userRoleService.updateUser(User);
//
//		return new ResponseEntity<User>(User, HttpStatus.OK);
//	}
//
//	@DeleteMapping("User/{id}")
//	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
//
//		userRoleService.deleteUser(id);
//
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}	
}  