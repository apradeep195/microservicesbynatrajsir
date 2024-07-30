package com.heg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heg.bo.EmployeeBO;
import com.heg.dao.IEmployeeDAO;
import com.heg.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public List<EmployeeDTO> fetchEmpByDesg(String[] desgs) throws Exception {
		
		String condition=null;
		//Convert designation array into sql in clause string condition('MANAGER','EXECUTIVE')
		StringBuffer buffer=new StringBuffer("(");
		for(int i=0;i<desgs.length;i++) {
			
			if(i==desgs.length-1) {
				buffer.append("'"+desgs[i]+"')");
			}else {
				buffer.append("'"+desgs[i]+"',");
			}
			
		}
		System.out.println("STRING PRINT HERE  " +buffer);
		
		//Buffer convert into String 
		condition=buffer.toString();
		System.out.println("CONDITION PRINT HERE " +condition);
		
		List<EmployeeBO> listBO= dao.getEmpsByDesg(condition);
		//Convert listBO to List DTO
		List<EmployeeDTO> listDTO=new ArrayList<>();
		listBO.forEach(bo->{
			EmployeeDTO dto= new EmployeeDTO();
			//Copy each BO class object data to each DTO class object DATA
			BeanUtils.copyProperties(bo, dto); //property names and types must match in both java beans
			dto.setSrNo(listDTO.size()+1);
			//add each object of DTO class to ListDTO
			listDTO.add(dto);
			
		});
		
		
		return listDTO;
	}//for

}//class
