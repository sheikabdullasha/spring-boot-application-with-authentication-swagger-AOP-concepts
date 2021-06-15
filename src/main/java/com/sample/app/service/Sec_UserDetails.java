package com.sample.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.app.entity.Customer;
import com.sample.app.entity.SecurityCustomer;
import com.sample.app.repo.CustomerRepository;
@Service
public class Sec_UserDetails implements UserDetailsService{
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CustomerRepository custrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<Customer> customer=custrepo.findByEmail(username);
		if(customer.size()==0) {
			throw new UsernameNotFoundException("user detail not found for the user "+ username);
		}
		
		log.debug("login success................");
		
		return new SecurityCustomer(customer.get(0));
	}

}
