package com.demo.crudOperation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crudOperation.model.User;
import com.demo.crudOperation.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders="*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> userList = userService.getAllUser();
		for (User user : userList) {
			System.out.println(user.getFname());
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userService.getByUserID(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		System.out.println(id);
		userService.deleteUser(id);
		return true;		
	}
	@PostMapping("/user")
	public ResponseEntity<User> getUser(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userService.update(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
