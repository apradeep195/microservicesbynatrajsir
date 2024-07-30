package com.heg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heg.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
