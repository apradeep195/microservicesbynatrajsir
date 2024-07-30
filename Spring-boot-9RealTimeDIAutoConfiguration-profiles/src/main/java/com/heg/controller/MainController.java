package com.heg.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.heg.dto.EmployeeDTO;
import com.heg.service.IEmployeeMgmtService;
import com.heg.vo.EmployeeVO;

import java.util.ArrayList;
import java.util.List;


@Controller("controller")
public class MainController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	public MainController() {
		System.out.println("O PARAM CONSTRUCTOR :: MainController" );
	}
	
	
	public List<EmployeeVO> showEmpsByDesgs(String[] degs) throws Exception{
		
		//User service
		List<EmployeeDTO> listDTO= service.fetchEmpByDesg(degs);
		
		//Convert to listDTO to listVo
		List<EmployeeVO> listVo=new ArrayList<>();
		listDTO.forEach(dto->{
			EmployeeVO vo=new EmployeeVO();
			BeanUtils.copyProperties(dto,vo);
			vo.setSrNo(String.valueOf(dto.getSrNo()));
			vo.setEmpno(String.valueOf(dto.getEmpno()));
			vo.setZip(String.valueOf(dto.getZip()));
			vo.setCity(dto.getCity());
			vo.setCountry(dto.getCountry());
			vo.setDept(dto.getDept());
			vo.setDesignation(dto.getDesignation());
			vo.setEmail(dto.getEmail());
			vo.setName(dto.getName());
			vo.setUnit(dto.getUnit());
			listVo.add(vo);
			
		});
		return listVo;
		
		
	}

}
