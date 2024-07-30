package com.heg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.entity.Tourist;
import com.heg.exception.TouristNotFoundException;
import com.heg.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtService implements ITouristMgmtService {

	@Autowired
	private ITouristRepo repo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		// TODO Auto-generated method stub
		return repo.save(tourist).getTid() + " Registered Successfully" ;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		// TODO Auto-generated method stub
		
		List<Tourist> list=repo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer id) throws TouristNotFoundException {
		// TODO Auto-generated method stub
		return repo.findById(id)
				.orElseThrow(()->new TouristNotFoundException(id +"Toursit Not Found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Tourist> optional=repo.findById(tourist.getTid());
		if(optional.isPresent()) {
			repo.save(tourist);
			return tourist.getTid() + "Updated Successfully";
		}else {
			throw new TouristNotFoundException(tourist.getTid()+" Tourist not found ");
		}
		
	}

	@Override
	public String deleteToursit(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> optional=repo.findById(tid);
		if(optional.isPresent()) {
			repo.deleteById(tid);
			return tid + " Deleted Successfully";
		}else {
			throw new TouristNotFoundException(tid +" Tourist not found for remove records ");
		}
	}

	@Override
	public String updateTouristBudget(Integer tid, Float hikePercent) throws TouristNotFoundException {
		Optional<Tourist> optional=repo.findById(tid);
		
		if(optional.isPresent()) {
			Tourist tourist=optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikePercent/20)));
			repo.save(tourist);
			return tid + " Tourist budget updated";
		}else {
			throw new TouristNotFoundException(tid +" Tourist not found ::::");
		}
	}

}
