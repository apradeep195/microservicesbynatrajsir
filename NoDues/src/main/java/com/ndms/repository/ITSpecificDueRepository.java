package com.ndms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ndms.model.ITSpecificDueModel;

@Repository
public interface ITSpecificDueRepository  extends JpaRepository<ITSpecificDueModel, Long> {
	
	ITSpecificDueModel findByNoDuesReq_ID(Long reqId);
	
	

}
