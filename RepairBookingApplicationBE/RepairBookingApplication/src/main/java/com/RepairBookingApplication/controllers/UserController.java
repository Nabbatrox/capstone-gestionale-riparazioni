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

import com.RepairBookingApplication.DTO.RegisterDTO;
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
	    
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private UserService userService;
	    
	@Autowired
	private RoleService roleService;
	    
	    
//---------------------------- Get ---------------------------------
	    
	@GetMapping("/getall")
//	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<List<User>> getUserList() {
	    	
		List<User> res = userService.getAll();
	        
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
public User saveUser(@RequestBody RegisterDTO dto) {

	User user = User.builder()
			.username(dto.getUsername())
			.firstname(dto.getFirstname())
			.lastname(dto.getLastname())
			.email(dto.getEmail())
			.password(encoder.encode(dto.getPassword()))
			.active(true)
			.roles(new HashSet<Role>())
			.build();

	user.addRole(roleService.getByRole(RoleType.ROLE_USER));

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
	            @RequestBody User u
	            ) {

	        User user = userService.getById(id);
	        
	        if(u.getUsername() != null) user.setUsername(u.getUsername());
	        if(u.getFirstname() != null) user.setFirstname(u.getFirstname());
	        if(u.getLastname()!= null) user.setLastname(u.getLastname());	        
	        if(u.getEmail() != null) user.setEmail(u.getEmail());
	        if(u.getPassword() != null) user.setPassword(u.getPassword());

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
