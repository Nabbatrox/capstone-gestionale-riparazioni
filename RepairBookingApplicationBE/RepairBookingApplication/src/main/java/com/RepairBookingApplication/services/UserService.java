package com.RepairBookingApplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.RepairBookingApplication.exceptions.NotFoundException;
import com.RepairBookingApplication.models.User;
import com.RepairBookingApplication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public User save(User x) {
		x.setPassword(encoder.encode(x.getPassword()));
        return userRepository.save(x);
    }

    public Page<User> getAll(Pageable p) {
        return userRepository.findAll(p);
    }

    public User getById(Long id) {

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty())
            throw new NotFoundException("User not available");

        return user.get();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
