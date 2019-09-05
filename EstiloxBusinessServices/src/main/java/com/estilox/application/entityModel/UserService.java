package com.estilox.application.entityModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estilox.application.security.JwtGenerator;
import com.estilox.application.security.JwtUser;
import com.estilox.application.utils.MailUtil;

@Service
public class UserService {
	
	@Autowired
	public UserCartRepository userCartRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	private JwtGenerator JwtGenerator;
	
	@Autowired
	private MailUtil mailutil;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Value("${user.key}")
	private String secretKeyUserpassword;
	
	public List<UserCartDto> getUserCartList(String emailId){
		List<UserCartDto> userCarts = null;
		User user = userRepository.findUserByEmailId(emailId);
		if(user != null) {
			userCarts = new ArrayList<>();
			for(UserCart userCart : user.getUserCart()) {
				UserCartDto userCartDto = new UserCartDto();
				userCartDto.setId(userCart.getId());
				userCartDto.setProductName(userCart.getProducts().getProductName());
				userCartDto.setImagePath(getImagePath(userCart.getProducts()));
				userCartDto.setQuantity(userCart.getProducts().getQuantity());
				userCartDto.setOfferPrice(userCart.getProducts().getDiscountPrice());
				userCartDto.setPrice(userCart.getProducts().getRegularPrice());
				userCarts.add(userCartDto);
			}
		}
		return userCarts;
	}
	
	private String getImagePath(Products products) {
		for (ProductImages productImages : products.getProductImages()) {
			return productImages.getFolderName()+"/"+productImages.getPath();
		}
		return null;
	}

	public Integer addToCart(UserCart userCart){
		List<UserCartDto> userCarts = null;
		if(userCart != null && userCart.getUser() != null) {
			if(userCart.getProducts() != null) {
				User user = userRepository.findUserByEmailId(userCart.getUser().getEmailId());
				userCart.setUser(user);
				Products products = productRepository.findOne(userCart.getProducts().getId());
				userCart.setProducts(products);
				userCartRepository.save(userCart);
				userCarts = getUserCartList(user.getEmailId());
				return userCarts.size();
			}
		}
		return null;
	}
	
	
	public User saveUser(User user) {
		if(userRepository.findUserByEmailId(user.getEmailId()) == null) {
			try {	
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword().toString()+user.getEmailId()));
				user.setInsertedAt(new Date());
				user.setUpdatedAt(new Date());
				userRepository.save(user);
				user.setStatusMessage("User created successfuly.");
			} catch (Exception e) {
				user.setStatusMessage("Error creating user.");
			}
		}else {
			user.setStatusMessage("EmailId already exists.");
		}
		return user;
	}

	public User findUser(User user) {
		User retrievedDb = userRepository.findUserByEmailId(user.getEmailId());
		if(retrievedDb != null && bCryptPasswordEncoder.matches(user.getPassword()+user.getEmailId(), retrievedDb.getPassword())) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setId(retrievedDb.getId());
			jwtUser.setEmailId(retrievedDb.getEmailId());
			user.setToken(JwtGenerator.generate(jwtUser));
			return user;
		}
		return null;
	}

	public String userForgotPassword(User user) {
		if(userRepository.findUserByEmailId(user.getEmailId()) != null) {
			try {
				mailutil.sendMail(user.getEmailId());
				return "Reset link sent to mail";
			} catch (Exception e) {
				e.printStackTrace();
				return "500 oops facing technical issue";
			}
		}
		return "User doesn't exists";
	}

	public List<UserCartDto> deleteFromCart(UserCartDto userCartDto) {
		UserCart userCart = userCartRepository.findOne(userCartDto.getId());
		if(userCart != null && userCart.getUser() != null) {
			userCartRepository.deleteCartItem(userCart.getId());
			return getUserCartList(userCart.getUser().getEmailId());
		}
		return null;
	}
	
}
