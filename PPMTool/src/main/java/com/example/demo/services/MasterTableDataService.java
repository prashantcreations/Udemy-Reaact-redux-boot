package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Role;
import com.example.demo.domain.RoleName;
import com.example.demo.repository.RoleRepository;
@Component
public class MasterTableDataService implements ApplicationRunner{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		if(roleRepository.count()==0) {
			for(RoleName role : RoleName.values()) {
				roleRepository.save(new Role(role));
			}
		}
	}
	
	

}
