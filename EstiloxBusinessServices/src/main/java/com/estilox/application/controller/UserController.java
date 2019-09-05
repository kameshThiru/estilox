package com.estilox.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilox.application.entityModel.User;
import com.estilox.application.entityModel.UserCart;
import com.estilox.application.entityModel.UserCartDto;
import com.estilox.application.entityModel.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	public UserService userService;
	
	@PostMapping("/service/user/userCartList")
	public List<UserCartDto> getUserCartList(@RequestBody User user){
		return userService.getUserCartList(user.getEmailId());
	}

	@PostMapping("/service/user/addToCart")
	public Integer addToCart(@RequestBody UserCart userCart){
		return userService.addToCart(userCart);
	}
	
	@PostMapping("/service/user/deleteFromCart")
	public List<UserCartDto> deleteFromCart(@RequestBody UserCartDto userCartDto){
		return userService.deleteFromCart(userCartDto);
	}
	
	@PostMapping("/user/signUp")
	public User userSignUp(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PostMapping("/user/login")
	public User userLogin(@RequestBody User user) {
		return userService.findUser(user);
	}
	
	@PostMapping("/user/forgotPassword")
	public String userForgotPassword(@RequestBody User user) {
		return userService.userForgotPassword(user);
	}	
	
	@GetMapping("/service/hello")
	public String getString() {
		return "Hello....";
	}
}
