package com.ndms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ndms.model.SectionAuthorityModel;

@Repository
public interface SectionAuthorityRepository extends JpaRepository<SectionAuthorityModel,Long> {

}
