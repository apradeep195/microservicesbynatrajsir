package com.heg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heg.entity.Person;
import com.heg.entity.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {

}
