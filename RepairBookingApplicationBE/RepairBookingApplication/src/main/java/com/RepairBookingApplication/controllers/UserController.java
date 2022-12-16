package com.RepairBookingApplication.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RepairBookingApplication.models.Role;
import com.RepairBookingApplication.models.RoleType;
import com.RepairBookingApplication.models.User;
import com.RepairBookingApplication.services.RoleService;
import com.RepairBookingApplication.services.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RequestMapping("/api/users")
public class UserController {
		

	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	    
//	@Autowired
//	PasswordEncoder encoder;

	@Autowired
	private UserService userService;
	    
	@Autowired
	private RoleService roleService;
	    
	    
//---------------------------- Get ---------------------------------
	    
	@GetMapping("/getall")
//	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<Page<User>> getUserList(Pageable p) {
	    	
		Page<User> res = userService.getAll(p);
	        
	 	if (res.isEmpty()){
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	} else{
	          return new ResponseEntity<>(res, HttpStatus.OK);
	    	}
	}

	@GetMapping("{id}")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public User getUserById(@PathVariable("id") Long id) {
	    return userService.getById(id);
	    }
	    
//---------------------------- Post --------------------------------

@PostMapping("/register")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public User saveUser(@RequestBody User user) {
		user.setActive(true);
	    logger.info("Save User in UserController");
	    return userService.save(user);
	   
}

//---------------------------- Put ---------------------------------
	    
		@PutMapping("/{id}/add-role/{idruolo}")
//		@PreAuthorize("hasRole('ADMIN')")
		public void addRole(@PathVariable("id") Long id,
							@PathVariable("idruolo") Long idruolo) {
			User user = userService.getById(id);
			Set<Role> roles = user.getRoles();
			roles.add(roleService.getById(idruolo));
			user.setRoles(roles);
			
			
			userService.save(user);
			 logger.info("Role added");
		}

	    @PutMapping("{id}")
	    @PreAuthorize("hasAnyRole()")
	    public User updateUser(
	            @PathVariable("id") Long id,
	            @RequestParam(value="email",required=false) String email,	            
	            @RequestParam(value="name",required=false) String firstname,
	            @RequestParam(value="lastname",required=false) String lastname,
	            @RequestParam(value="username",required=false) String username,
	            @RequestParam(value="password",required=false) String password
	            ) {

	        User user = userService.getById(id);
	        
	        if(username != null) user.setUsername(username);
	        if(firstname != null) user.setFirstname(firstname);
	        if(lastname != null) user.setLastname(lastname);	        
	        if(email != null) user.setEmail(email);
	        if(password != null) user.setPassword(password);

	        userService.save(user);
	        return user;
	    }

	// -------------------------- Delete -------------------------------

	    @DeleteMapping("{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    public String deleteUserById(@PathVariable("id") Long id) {
	        userService.deleteById(id);
	        return "User deleted successfully";
	    }

}
