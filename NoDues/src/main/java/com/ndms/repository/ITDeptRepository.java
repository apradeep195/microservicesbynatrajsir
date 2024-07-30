package com.ndms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ndms.dto.ItDepatmentDuesDetailsDTO;
import com.ndms.dto.LnerpDTO;
import com.ndms.dto.MailDetailsDTO;
import com.ndms.model.EmployeeRoleModel;

@Repository
public interface ITDeptRepository extends JpaRepository<EmployeeRoleModel, Long> {

	@Query(nativeQuery = true,value = "select T$EMNO as empcode, T$NAMA as empname,\r\n"
			+ "T$SEAK as skkll,\r\n"
			+ "T$LOCO as erplogin  from baan.ttccom001804@baan2ln where rtrim(T$EMNO)=(select rtrim(EMPNO) from hr.NODUES_REQ_DETAILS where id=:reqid) and t$emno is not null")
	LnerpDTO getLnerpnDetails(Long reqid);
	
	
	@Query(nativeQuery = true,value="select count(*) from AUTOMAIL_RECIPIENTS where REC_STATUS='Active' and RECIPIENT_CODE=(select empno from NODUES_REQ_DETAILS where id=:reqid)")
    Integer  getAutomailcount(Long reqid)	;
	
	@Query(nativeQuery = true,value="select count(T$EMAIL2) from baan.thrper002804 where t$empno=(select empno from nodues_req_details where id=:reqid)")
   Integer getEmailCount(Long reqid);
	
	
	@Query(nativeQuery = true,value="select count(*) from hegc.it_resource_master@baan2ln where stat='Granted' and ecno=(select empno from nodues_req_details where id=:reqid)")
	   Integer getEmailCount2(Long reqid);
	
	
	@Query(nativeQuery = true,value="select T$EMAIL2 from baan.thrper002804 where t$empno=(select empno from nodues_req_details where id=:reqId)")
	String  getMailInfoFromBAAN(Long reqId);
	
	@Query(nativeQuery = true,value="select RCAT from hegc.it_resource_master@baan2ln where stat='Granted' and ecno=(select empno from NODUES_REQ_DETAILS where id=:reqId) and RCAT In ('ExternalMail','InternalMail')")
	String  getMailInfoITResource(Long reqId);
	
	
	@Query(nativeQuery = true,value="select  ID as id , ERP_LOGIN_STATUS as erploginstatus, ERP_LOGIN as erplogin,ERP_LOGIN_ACTION  erploginaction ,MAIL_ID_ALOTED mailalloted ,MAIL_ID_REMOVED as mailremoved,MAIL_TYPE  as mailtype,AUTOMAIL_ALOTED as automailalloted ,AUTOMAIL_REMOVED as automailremoved ,PC_PRINTER_ALOTED  as printeralloted,PC_PRINTER_RETURN as printeremoved,REMARK from  NODUES_IT_SPEC_DUE_DETAILS where  REQ_ID=:reqId")
	ItDepatmentDuesDetailsDTO  getItDuesDetailsEntered(Long reqId);
	
	
	
	
}




