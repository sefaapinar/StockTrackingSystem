package com.StokTakip.Controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StokTakip.DTO.UserCreateDTO;
import com.StokTakip.Exception.Exceptions;
import com.StokTakip.Model.Category;
import com.StokTakip.Model.Store;
import com.StokTakip.Model.User;
import com.StokTakip.Service.CategoryServiceImpl;
import com.StokTakip.Service.StoreServiceImpl;
import com.StokTakip.Service.UserServiceImpl;
import com.StokTakip.Util.Base64Token;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserServiceImpl  userService;
	
	@Autowired
	CategoryServiceImpl categoryService;
	
	@Autowired 
	StoreServiceImpl storeService; 
	
	
	@GetMapping("/{id}")
	  ResponseEntity<Object> getUser(@PathVariable int id) {
	   try {
	    	
		  Optional<User> user=userService.getUserById(id);
		  
		  // KULLANICIYA AİT CATEGORİ BİLGİSİ SORGULA (ONE TO MANY)
		  // KULLANICIYA AİT DEPO BİLGİSİ SORGULA (ONE TO MANY)
		  // to do.
		  
		  
			return  ResponseEntity
		            .status(HttpStatus.OK)
		            .body(user);
			
		} catch (Exception e) {
			return  ResponseEntity
		            .status(HttpStatus.CONFLICT)
		            .body(e.getMessage());
		}
	  }
	
	
	
	
	@PostMapping("register")
    public ResponseEntity<String> addUser(@RequestBody UserCreateDTO Userdto) {
		
		User user=new User(Userdto.getName(),Userdto.getEmail(),Userdto.getPassword(),new Date(),null);
		
		try {
			
			userService.createUser(user);
			
			user=userService.findByEmail(Userdto.getEmail());
			
			Category category=new Category(user.getId(), "default", "default category",new Date(),false);
			
			Store store =new Store(user.getId(),"default","default","default store",new Date(),false);
			
			categoryService.createCategory(category);
			storeService.createStore(store);
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Kayıt Başarılı");
			
			
		} catch (Exceptions e) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
		
		
		
	}
	
	
	
	@PostMapping("/login")
	 public ResponseEntity<Object> authUser(@RequestBody User user) {
		
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			
		    user =userService.findByEmail(user.getEmail());
		    
			if(user.getPassword().equals(user.getPassword())) {
				String token=Base64Token.encode(user.getEmail(),user.getPassword());
				 headers.add(HttpHeaders.AUTHORIZATION, token);
				 
			     return ResponseEntity
			    		 .status(HttpStatus.OK)
			    		 .headers(headers)
			    		 .body(user);
			}else
			{
				return ResponseEntity
			            .status(HttpStatus.UNAUTHORIZED)
			            .body("Parola Hatalı.");
			}
			
			} catch (Exception e) {
				return ResponseEntity
			            .status(HttpStatus.UNAUTHORIZED)
			            .body(e.getMessage());
		}
		
		
		
	}
	
	 @PutMapping("/{id}")
	  ResponseEntity<String> updateUser(@RequestBody User user,
			   @PathVariable int id) {
		 
		  user=new User(id,user.getName(),user.getEmail(),user.getPassword(),new Date());
		 
	    try {
	    	userService.updateUser(user);
			return  ResponseEntity
		            .status(HttpStatus.OK)
		            .body("Kullanıcı Başarıyla Güncellendi");
			
		} catch (Exception e) {
			return  ResponseEntity
		            .status(HttpStatus.CONFLICT)
		            .body(e.getMessage());
		}
	  }
	
	
	
	

}
