package com.heg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heg.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

}
