package com.RepairBookingApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RepairBookingApplication.exceptions.NotFoundException;
import com.RepairBookingApplication.models.Role;
import com.RepairBookingApplication.models.RoleType;
import com.RepairBookingApplication.repositories.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
    private RoleRepository repository;

    public Role save(Role x) {
        return repository.save(x);
    }

    public List<Role> getAll() {
        return repository.findAll();
    }

    public Role getById(Long id) {

        Optional<Role> role = repository.findById(id);

        if(!role.isPresent())
            throw new NotFoundException("Role not available");

        return role.get();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public Role getByRole(RoleType roleType) {		
		Optional<Role> role = repository.findByRoleType(roleType);
		if (!role.isPresent())
			throw new NotFoundException("Role not available");
		return role.get();
	}

}
