package com.cognizant.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.model.UserTruyum;
import com.cognizant.repository.UserRepository;



@Service
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository urepo;
	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserTruyum custuser=urepo.findById(uid).orElse(null);
		System.out.println(custuser+"\n\n\n\n");
		return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());
		
		
	}

}
