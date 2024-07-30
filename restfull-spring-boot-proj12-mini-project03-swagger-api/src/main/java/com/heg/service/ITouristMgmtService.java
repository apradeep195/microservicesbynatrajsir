package com.heg.service;

import java.util.List;

import com.heg.entity.Tourist;
import com.heg.exception.TouristNotFoundException;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);
	
	public List<Tourist>  fetchAllTourist();
	
	public Tourist fetchTouristById(Integer id) throws TouristNotFoundException;
	
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
	
	public String deleteToursit(Integer tid) throws TouristNotFoundException;
	
	public String updateTouristBudget(Integer tid,Float hikePercent) throws TouristNotFoundException;
}
