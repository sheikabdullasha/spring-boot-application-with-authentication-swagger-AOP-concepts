package com.sample.app.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.app.entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{

	List<Customer> findByEmail(String email);
}
