package com.heg.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.heg.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	//@Query("FROm com.heg.entity.CoronaVaccine WHERE company=?1")
	//@Query("FROM CoronaVaccine WHERE company=?1")
	//@Query("FROM CoronaVaccine as cv WHERE company=?1")
	//@Query("select cv FROM CoronaVaccine as cv WHERE company=?1")
//	@Query("select cv FROM CoronaVaccine as cv WHERE company=:company")
//	public List<CoronaVaccine> serachVaccineByComapny(String company);
	
	
	
	@Query("select cv FROM CoronaVaccine as cv WHERE company=:comp")
	public List<CoronaVaccine> serachVaccineByComapny(@Param("comp") String vendor);
	
	//=================NON SELECT OPERATION==========================
	
	@Modifying
	@Query("update CoronaVaccine set price=:newPrice where country=:country")
	public int updatePriceByCountry(double newPrice,String country);
	
	@Modifying
	@Query("DELETE FROM CoronaVaccine WHERE price BETWEEN :startPrice AND :endPrice")
	public int deleteVaccineByPriceRange(double startPrice,double endPrice);
	
	
	@Modifying
	@Transactional
	@Query(value="insert into corona_vaccine (price,required_doses,req_no,company,country,name) values (?,?,?,?,?,?)", nativeQuery=true)
	//@Query(nativeQuery = true,value= "insert into corona_vaccine (price,required_doses,req_no,company,country,name) values (?,?,?,?,?,?)")
	public int insertVaccine(Double price,int  required_doses, Long req_no,String  company,String  country,String name);
	
	@Modifying
	@Transactional
	@Query(value = "update corona_vaccine set price=?1,company=?3,country=?4,name=?5   where req_no=?2", nativeQuery = true)
	public int updateRecords(Double price, Long req_no,String  company,String  country,String name);
	
	
	@Query(value = "select   curdate() from dual" , nativeQuery = true)
	public Date getSystemDate();
	
}
