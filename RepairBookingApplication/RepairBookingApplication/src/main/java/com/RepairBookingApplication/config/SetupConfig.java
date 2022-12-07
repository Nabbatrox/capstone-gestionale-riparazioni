package com.RepairBookingApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

import com.RepairBookingApplication.models.Role;
import com.RepairBookingApplication.models.RoleType;

@Configuration
@Order(1)
public class SetupConfig {

	@Bean(name = "roleAdmin")
	@Scope("singleton")
	public Role roleAdmin() {
		
		return Role.builder()
				.roleType(RoleType.ROLE_ADMIN)
				.build();

	}

	@Bean(name = "roleUser")
	@Scope("singleton")
	public Role roleUser() {
		
		return Role.builder()
				.roleType(RoleType.ROLE_USER)
				.build();
		
	}
}
