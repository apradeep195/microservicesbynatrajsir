package com.pws.tutorial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pws.tutorial.bo.EmployeeBO;
import com.pws.tutorial.dao.IEmployeeDAO;
import com.pws.tutorial.dto.EmployeeDTO;

@Service("empService")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public List<EmployeeDTO> fetchEmployeeByDesignation(String[] desgs) throws Exception {
		
		// convert desgs[] into SQL IN clause String condition('CLERK','MANAGER','SALESMAN')
		//String cond=null;
		
//		StringBuilder buffer=new StringBuilder("(");
//		for(int i=0;i<=desgs.length;++i) {
//			
//			if(i==desgs.length-1){//for the last element of array
//				buffer.append("'"+desgs[i]+"')");
//			
//			}else {
//				buffer.append("'"+desgs[i]+"',");
//			
//			}
//		}//for
		String cond="('MANAGER') ";
		System.out.println("COND" +cond);
		
		//convert string buffer to string
		//use DAO
		
			List<EmployeeBO> listBO=dao.getEmplByDesg(cond);
			//convert LISTBO to LIST DTO
			
			List<EmployeeDTO> listDTO=new ArrayList<>();
			listBO.forEach(bo->{
				EmployeeDTO dto=new EmployeeDTO();
				//Copy each BO class object to each DTO class object
				BeanUtils.copyProperties(bo, dto);//property names and type  must match
				dto.setSrNo(listDTO.size()+1);
				
				//add each object of DTO class to List DTO
				listDTO.add(dto);
			});
			
	
		
		
		return listDTO;
	}

}
