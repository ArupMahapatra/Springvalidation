package com.jt.validation.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.validation.pojo.UserLogin;

public interface LoginRepository extends JpaRepository<UserLogin, Integer> {

UserLogin	findByNameAndPassword(String name,String pass);
	
}
