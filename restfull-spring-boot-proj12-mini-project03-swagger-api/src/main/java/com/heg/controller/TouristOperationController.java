package com.heg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heg.entity.Tourist;
import com.heg.service.ITouristMgmtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tourist")
@Api("All about tourist")
public class TouristOperationController {

	@Autowired
	private ITouristMgmtService service;

	@PostMapping("/enroll")
	@ApiOperation("For Tourist Registration")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) throws Exception {
	/*	try {
			// Use Service
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in Enroll tourist", HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		
		String resultMsg = service.registerTourist(tourist);
		return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
	}

	/*
	 * @GetMapping("/report") public ResponseEntity<List<Tourist>>
	 * displayAllTouristNonGeneric(){ try { List<Tourist>
	 * list=service.fetchAllTourist(); return new
	 * ResponseEntity<List<Tourist>>(list,HttpStatus.OK); }catch(Exception ex) {
	 * ex.printStackTrace(); return new
	 * ResponseEntity<String>("Problem in fetch Tourist",HttpStatus.
	 * INTERNAL_SERVER_ERROR); } }
	 */

	// Case of generic because there problem with return type is list of respomse by
	// if any problem occured i want to send single string

	@GetMapping("/findAll")
	public ResponseEntity<?> displayAllTourist() throws Exception {
	/*	try {
			List<Tourist> list = service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>("Problem in fetch Tourist", HttpStatus.INTERNAL_SERVER_ERROR);
		} */
		
		List<Tourist> list = service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) throws Exception{
		/*try {
			
			Tourist tourist=service.fetchTouristById(id);			
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>("Toursit not found with id " +id,HttpStatus.INTERNAL_SERVER_ERROR);
		} */
		
		Tourist tourist=service.fetchTouristById(id);			
		return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) throws Exception{
		
	/*	try {
		String resultMsg=	service.updateTouristDetails(tourist);
		return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		
		String resultMsg=	service.updateTouristDetails(tourist);
		return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeToursit(@PathVariable("id") Integer id) throws Exception{
		//user service
		
	/*	try {
			String msg=service.deleteToursit(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}*/
		
		String msg=service.deleteToursit(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifyTouristBudget(@PathVariable("id") Integer id,
														@PathVariable("hike") Float hikePersent) throws Exception{
		//user Service
	/*	try {
			String msg=service.updateTouristBudget(id,hikePersent);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}*/
		
		String msg=service.updateTouristBudget(id,hikePersent);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}	 
}
