package com.pws.tutorial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pws.tutorial.dto.EmployeeDTO;
import com.pws.tutorial.service.IEmployeeManagementService;
import com.pws.tutorial.vo.EmployeeVO;

@Controller("controller")
public class MainController {

	@Autowired
	private IEmployeeManagementService service;

	public List<EmployeeVO> showEmpByDesgs(String desg[]) throws Exception {
		// use service
		List<EmployeeDTO> listDTO = service.fetchEmployeeByDesignation(desg);

		// convert ListDTO to listVO

		List<EmployeeVO> listVO = new ArrayList<>();
		listDTO.forEach(dto -> {
			EmployeeVO vo = new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSrNo(String.valueOf(dto.getSrNo()));
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMngNo(String.valueOf(dto.getMngNo()));
			vo.setJob(String.valueOf(dto.getJob()));
			listVO.add(vo);

		});

		return listVO;

	}

}
