package com.RepairBookingApplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.RepairBookingApplication.models.Role;
import com.RepairBookingApplication.services.RoleService;
import com.RepairBookingApplication.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(2)
public class SetupRunner implements CommandLineRunner {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SetupConfig.class);

    @Autowired
    RoleService roleService;
    
    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {

        log.info("RUNNER SETUP START");

        createData();

        log.info("RUNNER SETUP END");

    }

    private void createData() {

//        roleService.save(ctx.getBean("roleAdmin", Role.class));
//        roleService.save(ctx.getBean("roleUser", Role.class));
    }
}
