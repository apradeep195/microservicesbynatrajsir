package com.heg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heg.model.Faculity;

public interface IFaculityRepo extends JpaRepository<Faculity, Integer> {

}
