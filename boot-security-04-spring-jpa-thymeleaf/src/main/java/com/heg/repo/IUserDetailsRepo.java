package com.heg.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.heg.model.UserDetails;

public interface IUserDetailsRepo extends CrudRepository<UserDetails, Integer> {

	public Optional<UserDetails> findByUname(String uname);
}
