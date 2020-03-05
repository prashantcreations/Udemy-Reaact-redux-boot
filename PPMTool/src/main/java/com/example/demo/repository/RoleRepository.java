package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Role;
import com.example.demo.domain.RoleName;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	List<Role> findByName(RoleName name);

}
