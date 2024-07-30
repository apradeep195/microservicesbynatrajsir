package com.ndms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ndms.model.SectionMasterModel;

@Repository
public interface SectionMasterRepository  extends JpaRepository<SectionMasterModel, Long>  {

}
