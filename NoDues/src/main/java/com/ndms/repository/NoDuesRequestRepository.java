package com.ndms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ndms.dto.DeptEmpLeftInfo;
import com.ndms.dto.DeptNameInfo;
import com.ndms.dto.HODPendingReqInfo;
import com.ndms.dto.PendingReqInfo;
import com.ndms.dto.RegisnationInfo;
import com.ndms.model.NoDuesRequestModel;

@Repository
public interface NoDuesRequestRepository extends JpaRepository<NoDuesRequestModel, Long> {
	
  @Query(nativeQuery = true,value="select count(*) from baan.thrmas038804 where t$empno=:empId")
  Integer checkIfExist(Long empId);
//NEW CODE START HERE 
//Query (Query for list of employee which relieving within 3 Month by row Size)
	@Query(nativeQuery = true, value = "SELECT e.t$empno  AS empcode, TRIM(a.t$name) AS empname,c.t$desc AS desg,d.t$desc AS unitdesc,b.t$desc AS deptdesc,to_date(e.t$lsdt, 'dd-mm-rrrr') AS lastdate,(SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = a.t$leavcd )  AS leaveresion ,(SELECT TRIM(t$name) FROM baan.thrper001804 WHERE t$empno = (SELECT amrecomd FROM tblapplymst_v WHERE amemplcd = e.t$empno )) AS repostingoffice,(SELECT TRIM(t$name) FROM baan.thrper001804 WHERE t$empno = (SELECT t$empno FROM baan.thrmas038804 WHERE t$deptcd = a.t$deptcd ))   AS pendingwith , a.t$catcd as catcode "
			+ "FROM baan.thrpay011804 e,baan.thrmas007804 c,baan.thrper001804 a,baan.thrmas020804 b,baan.thrmas018804 d "
			+ "WHERE a.t$empno = e.t$empno   AND a.t$deptcd = b.t$code AND a.t$unitcd = d.t$code AND a.t$desgcd = c.t$code AND to_char(e.t$lsdt, 'ddmmrr') NOT IN ( '000000' ) AND e.t$empno NOT IN (SELECT DISTINCT (empno ) FROM  nodues_req_details  \r\n"
			+ "UNION SELECT DISTINCT (emp_code) FROM nodues_section_authorities WHERE sysdate > access_from AND sysdate < access_to ) AND to_date(e.t$lsdt, 'dd-mm-rr') BETWEEN to_date(sysdate, 'dd-mm-yy') - 90 AND to_date(sysdate, 'dd-mm-yy') + 90 \r\n"
			+ "UNION \r\n"
			+ "SELECT a.t$empno AS empcode,TRIM(a.t$name) AS empname,c.t$desc  AS desg,d.t$desc  AS unitdesc,b.t$desc  AS deptdesc,to_date(add_months(to_date(a.t$join$dt, 'dd-mm-rrrr'), 12) - 1, 'dd-mm-rrrr') AS lastdate,\r\n"
			+ "(SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = a.t$leavcd ) AS leaveresion,NULL,(SELECT TRIM(t$name) FROM baan.thrper001804 WHERE t$empno=(SELECT t$empno FROM baan.thrmas038804 WHERE t$deptcd = a.t$deptcd )) AS pendingwith,a.t$catcd as catcode "
			+ "FROM  baan.thrper001904 a,baan.thrmas020804 b,baan.thrmas007804 c,baan.thrmas018804 d "
			+ "WHERE  a.t$deptcd = b.t$code AND a.t$unitcd = d.t$code AND a.t$desgcd = c.t$code AND to_char(a.t$leavdt, 'ddmmrr') IN ( '000000' )  AND a.t$empno NOT IN (SELECT DISTINCT (empno) FROM nodues_req_details UNION SELECT DISTINCT ( emp_code ) FROM nodues_section_authorities WHERE sysdate > access_from AND sysdate < access_to ) AND add_months(to_date(a.t$join$dt, 'dd-mm-rr'), 12) - 1 BETWEEN to_date(sysdate, 'dd-mm-yy') - 90 AND to_date(sysdate, 'dd-mm-yy') + 90")
	List<RegisnationInfo> getResignationInfo();
  

	// Query (Count for Nodues Inistite )
	@Query(nativeQuery = true, value = "select count(*) from (SELECT e.t$empno  AS empcode, TRIM(a.t$name) AS empname,c.t$desc AS desg,d.t$desc AS unitdesc,b.t$desc AS deptdesc,to_date(e.t$lsdt, 'dd-mm-rrrr') AS lastdate,(SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = a.t$leavcd )  AS leaveresion,(SELECT TRIM(t$name) FROM baan.thrper001804 WHERE t$empno = (SELECT amrecomd FROM tblapplymst_v WHERE amemplcd = e.t$empno )) AS repostingoffice,(SELECT TRIM(t$name) FROM baan.thrper001804 WHERE t$empno = (SELECT t$empno FROM baan.thrmas038804 WHERE t$deptcd = a.t$deptcd ))   AS pendingwith , a.t$catcd as catcode FROM baan.thrpay011804 e,baan.thrmas007804 c,baan.thrper001804 a,baan.thrmas020804 b,baan.thrmas018804 d WHERE a.t$empno = e.t$empno  AND a.t$deptcd = b.t$code AND a.t$unitcd = d.t$code AND a.t$desgcd = c.t$code AND to_char(e.t$lsdt, 'ddmmrr') NOT IN ( '000000' ) AND e.t$empno NOT IN (SELECT DISTINCT (empno ) FROM  nodues_req_details  \r\n"
			+ "UNION SELECT DISTINCT (emp_code) FROM nodues_section_authorities WHERE sysdate > access_from AND sysdate < access_to ) AND to_date(e.t$lsdt, 'dd-mm-rr') BETWEEN to_date(sysdate, 'dd-mm-yy') - 90 AND to_date(sysdate, 'dd-mm-yy') + 90 \r\n"
			+ "UNION \r\n"
			+ "SELECT a.t$empno AS empcode,TRIM(a.t$name) AS empname,c.t$desc  AS desg,d.t$desc  AS unitdesc,b.t$desc  AS deptdesc,to_date(add_months(to_date(a.t$join$dt, 'dd-mm-rrrr'), 12) - 1, 'dd-mm-rrrr') AS lastdate,\r\n"
			+ "(SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = a.t$leavcd ) AS leaveresion,NULL,(SELECT TRIM(t$name) FROM baan.thrper001804 WHERE t$empno=(SELECT t$empno FROM baan.thrmas038804 WHERE t$deptcd = a.t$deptcd )) AS pendingwith,a.t$catcd as catcode FROM  baan.thrper001904 a,baan.thrmas020804 b,baan.thrmas007804 c,baan.thrmas018804 d WHERE a.t$deptcd = b.t$code AND a.t$unitcd = d.t$code AND a.t$desgcd = c.t$code AND to_char(a.t$leavdt, 'ddmmrr') IN ( '000000' )  AND a.t$empno NOT IN (SELECT DISTINCT (empno) FROM nodues_req_details UNION SELECT DISTINCT ( emp_code ) FROM nodues_section_authorities WHERE sysdate > access_from AND sysdate < access_to ) AND add_months(to_date(a.t$join$dt, 'dd-mm-rr'), 12) - 1 BETWEEN to_date(sysdate, 'dd-mm-yy') - 90 AND to_date(sysdate, 'dd-mm-yy') + 90)")
	Integer getResignationCount();
	
	// Query (get Employee list which pending for confirmation of Department HOD)
		@Query(nativeQuery = true, value = " SELECT nd.id  AS reqid,per.t$empno AS EMPNO, per.t$name AS empname, \r\n"
				+ "   nd.resign_date AS resign_date, \r\n"
				+ "   per.T$LEAVDT as LAST_WORKING_DATE,\r\n"
				+ "  ( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,\r\n"
				+ "  nd.initiate_date,\r\n"
				+ "  dept.t$desc AS dept,\r\n"
				+ "    desg.t$desc    AS desg,\r\n"
				+ "   nd.hr_head_approva_status,\r\n"
				+ "   nd.hod_approval_status    \r\n"
				+ "FROM\r\n"
				+ "         baan.thrper001804 per\r\n"
				+ "    JOIN nodues_req_details nd ON per.t$empno = nd.empno\r\n"
				+ "    JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code\r\n"
				+ "    JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd     \r\n"
				+ "    where PER.T$DEPTCD in( SELECT t$deptcd FROM baan.thrmas038804 WHERE t$empno =  :empid  \r\n"
				+ "    union select DEPTCD from MANPOWER_DB_ADDITIONAL_ACCESS where EMPNO=:empid and sysdate between EFDT and ENDT  ) and ND.HOD_APPROVAL_STATUS=0   \r\n"
				+ "  UNION  \r\n"
				+ "SELECT nd.id  AS reqid,per.t$empno AS EMPNO, per.t$name AS empname, \r\n"
				+ "   nd.resign_date AS resign_date, \r\n"
				+ "   per.T$LEAVDT as LAST_WORKING_DATE,\r\n"
				+ "  ( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,\r\n"
				+ "  nd.initiate_date,\r\n"
				+ "  dept.t$desc AS dept,\r\n"
				+ "    desg.t$desc    AS desg,\r\n"
				+ "   nd.hr_head_approva_status,\r\n"
				+ "   nd.hod_approval_status    \r\n"
				+ "FROM\r\n"
				+ "         baan.thrper001904 per\r\n"
				+ "    JOIN nodues_req_details nd ON per.t$empno = nd.empno\r\n"
				+ "    JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code\r\n"
				+ "    JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd     \r\n"
				+ "    where PER.T$DEPTCD in( SELECT t$deptcd FROM baan.thrmas038804 WHERE t$empno =  :empid  \r\n"
				+ "    union select DEPTCD from MANPOWER_DB_ADDITIONAL_ACCESS where EMPNO=:empid and sysdate between EFDT and ENDT  ) and ND.HOD_APPROVAL_STATUS=0 ")
		List<HODPendingReqInfo> hodPendingInfo(Long empid);
	
	
		//Department HOD get All records CODE here............................
		
		@Query(nativeQuery=true,value="	SELECT nd.id  AS reqid,per.t$empno AS EMPNO,per.t$name AS empname, nd.resign_date AS resigndate,per.T$LEAVDT as lastworkingdate,( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,nd.initiate_date as initiateddate,dept.t$desc AS departmentt, desg.t$desc    AS designation, nd.HOD_APPROVAL_DATE AS hodapprovedate, (select trim(t$name) from baan.thrper001804 where t$empno=nd.HOD_CODE) as hodname, nd.HR_HEAD_APPROVA_DATE    as hrapprovedate,   (select trim(t$name) from baan.thrper001804 where t$empno=nd.HR_HEAD) as hrname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=1) as itdate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=1)) as itname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=2) as libdate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=2)) as libname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=3) as admindate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=3)) as adminname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=4) as storedate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=4)) as storename,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=5) as accntdate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=5)) as accntname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=6) as medidate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=6)) as mediname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=7) as timeofficedate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=7)) as timeofficename,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=8) as societydate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=8)) as societyname FROM baan.thrper001804 per JOIN nodues_req_details nd ON per.t$empno = nd.empno JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd     where PER.T$DEPTCD in( SELECT t$deptcd FROM baan.thrmas038804 WHERE t$empno = :empid union select DEPTCD from MANPOWER_DB_ADDITIONAL_ACCESS where EMPNO=:empid and sysdate between EFDT and ENDT  ) and ND.HOD_APPROVAL_STATUS=1  \r\n"
				+ " union \r\n"
				+ " 					SELECT nd.id  AS reqid,per.t$empno AS EMPNO,per.t$name AS empname, nd.resign_date AS resigndate,per.T$LEAVDT as lastworkingdate,( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,nd.initiate_date as initiateddate,dept.t$desc AS departmentt, desg.t$desc    AS designation, nd.HOD_APPROVAL_DATE AS hodapprovedate, (select trim(t$name) from baan.thrper001804 where t$empno=nd.HOD_CODE) as hodname, nd.HR_HEAD_APPROVA_DATE    as hrapprovedate,   (select trim(t$name) from baan.thrper001804 where t$empno=nd.HR_HEAD) as hrname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=1) as itdate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=1)) as itname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=2) as libdate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=2)) as libname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=3) as admindate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=3)) as adminname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=4) as storedate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=4)) as storename,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=5) as accntdate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=5)) as accntname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=6) as medidate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=6)) as mediname,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=7) as timeofficedate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=7)) as timeofficename,(select max(b.SUBMITTED_DATE) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=8) as societydate,(select t$name from baan.thrper001804 where t$empno=(select distinct(ENTERED_BY) from NODUES_SECTIONWISE_ND_DETAILS b where b.REQ_ID=nd.ID and b.sec_id=8)) as societyname FROM baan.thrper001904 per JOIN nodues_req_details nd ON per.t$empno = nd.empno JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd     where PER.T$DEPTCD in( SELECT t$deptcd FROM baan.thrmas038804 WHERE t$empno = :empid union select DEPTCD from MANPOWER_DB_ADDITIONAL_ACCESS where EMPNO=:empid and sysdate between EFDT and ENDT  ) and ND.HOD_APPROVAL_STATUS=1")
		List<DeptEmpLeftInfo> getDeptLeftEmployees(Long empid);
  
  //NEW CODE END HERE 
	
	
	
	
	
		
		
		
		
		
		
		
		
		

		//Query(Resigned Employee Information in this code )
		@Query(nativeQuery = true, value = " select count(*) from (Select  PER.T$EMPNO as EMPNO,PER.T$NAME AS EMPNAME,ND.ID as REQID,ND.RESIGN_DATE,ND.HR_HEAD_APPROVA_STATUS,ND.HOD_APPROVAL_STATUS,ND.REASON,ND.LAST_WORKING_DATE,ND.INITIATE_DATE,DEPT.T$DESC AS DEPT,DESG.T$DESC AS DESG from baan.thrper001804  PER Join NODUES_REQ_DETAILS ND  on PER.t$empno=Nd.EMPNO\r\n"
				+ " JOIN BAAN.THRMAS020804 DEPT on  PER.T$DEPTCD = DEPT.T$CODE JOIN BAAN.THRMAS007804 DESG on DESG.T$CODE=PER.T$DESGCD  \r\n"
				+ " UNION\r\n "
				+ " Select  PER.T$EMPNO as EMPNO,PER.T$NAME AS EMPNAME,ND.ID as REQID,ND.RESIGN_DATE,ND.HR_HEAD_APPROVA_STATUS,ND.HOD_APPROVAL_STATUS,ND.REASON,ND.LAST_WORKING_DATE,ND.INITIATE_DATE,DEPT.T$DESC AS DEPT,DESG.T$DESC AS DESG from baan.thrper001904  PER Join NODUES_REQ_DETAILS ND  on PER.t$empno=Nd.EMPNO\r\n"
				+ " JOIN BAAN.THRMAS020804 DEPT on  PER.T$DEPTCD = DEPT.T$CODE JOIN BAAN.THRMAS007804 DESG on DESG.T$CODE=PER.T$DESGCD )")
		Integer getResignedEmployeeCount();

		
		
	 
	
	//Query(Resigned Employee Information in this code )
	@Query(nativeQuery = true, value = " SELECT\r\n"
			+ "    per.t$empno AS empno,\r\n"
			+ "    per.t$name  AS empname,\r\n"
			+ "    nd.id       AS reqid,\r\n"
			+ "    nd.resign_date,\r\n"
			+ "    nd.hr_head_approva_status,\r\n"
			+ "    nd.hod_approval_status,\r\n"
			+ "    ( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,\r\n"
			+ "    per.T$LEAVDT as LAST_WORKING_DATE,\r\n"
			+ "    nd.initiate_date,\r\n"
			+ "    dept.t$desc AS dept,\r\n"
			+ "    desg.t$desc AS desg,\r\n"
			+ "    ( SELECT TRIM(t$name) FROM baan.thrper001804  WHERE t$empno = (SELECT amrecomd FROM tblapplymst_v WHERE amemplcd = per.t$empno )) AS repostingoffice\r\n"
			+ "FROM\r\n"
			+ "         baan.thrper001804 per\r\n"
			+ "    JOIN nodues_req_details nd ON per.t$empno = nd.empno\r\n"
			+ "    JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code\r\n"
			+ "    JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd\r\n"
			+ "    UNION \r\n"
			+ "      SELECT\r\n"
			+ "    per.t$empno AS empno,\r\n"
			+ "    per.t$name  AS empname,\r\n"
			+ "    nd.id       AS reqid,\r\n"
			+ "    nd.resign_date,\r\n"
			+ "    nd.hr_head_approva_status,\r\n"
			+ "    nd.hod_approval_status,\r\n"
			+ "    ( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,\r\n"
			+ "    per.T$LEAVDT as LAST_WORKING_DATE,\r\n"
			+ "    nd.initiate_date,\r\n"
			+ "    dept.t$desc AS dept,\r\n"
			+ "    desg.t$desc AS desg,\r\n"
			+ "    null\r\n"
			+ "FROM\r\n"
			+ "         baan.thrper001904 per\r\n"
			+ "    JOIN nodues_req_details nd ON per.t$empno = nd.empno\r\n"
			+ "    JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code\r\n"
			+ "    JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd")
	List<PendingReqInfo> getResignedEmployeeInfo();
	
	
	//Get All Pending Requests Details	
	@Query(nativeQuery = true, value = " SELECT\r\n"
			+ "    per.t$empno AS empno,\r\n"
			+ "    per.t$name  AS empname,\r\n"
			+ "    nd.id       AS reqid,\r\n"
			+ "    nd.resign_date,\r\n"
			+ "    nd.hr_head_approva_status,\r\n"
			+ "    nd.hod_approval_status,\r\n"
			+ "    ( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,\r\n"
			+ "    per.T$LEAVDT as LAST_WORKING_DATE,\r\n"
			+ "    nd.initiate_date,\r\n"
			+ "    dept.t$desc AS dept,\r\n"
			+ "    desg.t$desc AS desg,\r\n"
			+ "    ( SELECT TRIM(t$name) FROM baan.thrper001804  WHERE t$empno = (SELECT amrecomd FROM tblapplymst_v WHERE amemplcd = per.t$empno )) AS repostingoffice\r\n"
			+ "FROM\r\n"
			+ "         baan.thrper001804 per\r\n"
			+ "    JOIN nodues_req_details nd ON per.t$empno = nd.empno\r\n"
			+ "    JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code\r\n"
			+ "    JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd where nd.HR_HEAD_APPROVA_STATUS=0 \r\n"
			+ "    UNION \r\n"
			+ "      SELECT\r\n"
			+ "    per.t$empno AS empno,\r\n"
			+ "    per.t$name  AS empname,\r\n"
			+ "    nd.id       AS reqid,\r\n"
			+ "    nd.resign_date,\r\n"
			+ "    nd.hr_head_approva_status,\r\n"
			+ "    nd.hod_approval_status,\r\n"
			+ "    ( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,\r\n"
			+ "    per.T$LEAVDT as LAST_WORKING_DATE,\r\n"
			+ "    nd.initiate_date,\r\n"
			+ "    dept.t$desc AS dept,\r\n"
			+ "    desg.t$desc AS desg,\r\n"
			+ "    null\r\n"
			+ "FROM\r\n"
			+ "         baan.thrper001904 per\r\n"
			+ "    JOIN nodues_req_details nd ON per.t$empno = nd.empno\r\n"
			+ "    JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code\r\n"
			+ "    JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd where nd.HR_HEAD_APPROVA_STATUS=0")
	List<PendingReqInfo> getPendingRequests();
	
	//Get All Approved Requests Details
	@Query(nativeQuery = true, value = " SELECT\r\n"
			+ "    per.t$empno AS empno,\r\n"
			+ "    per.t$name  AS empname,\r\n"
			+ "    nd.id       AS reqid,\r\n"
			+ "    nd.resign_date,\r\n"
			+ "    nd.hr_head_approva_status,\r\n"
			+ "    nd.hod_approval_status,\r\n"
			+ "    ( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,\r\n"
			+ "    per.T$LEAVDT as LAST_WORKING_DATE,\r\n"
			+ "    nd.initiate_date,\r\n"
			+ "    dept.t$desc AS dept,\r\n"
			+ "    desg.t$desc AS desg,\r\n"
			+ "    ( SELECT TRIM(t$name) FROM baan.thrper001804  WHERE t$empno = (SELECT amrecomd FROM tblapplymst_v WHERE amemplcd = per.t$empno )) AS repostingoffice\r\n"
			+ "FROM\r\n"
			+ "         baan.thrper001804 per\r\n"
			+ "    JOIN nodues_req_details nd ON per.t$empno = nd.empno\r\n"
			+ "    JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code\r\n"
			+ "    JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd where nd.HR_HEAD_APPROVA_STATUS=1 \r\n"
			+ "    UNION \r\n"
			+ "      SELECT\r\n"
			+ "    per.t$empno AS empno,\r\n"
			+ "    per.t$name  AS empname,\r\n"
			+ "    nd.id       AS reqid,\r\n"
			+ "    nd.resign_date,\r\n"
			+ "    nd.hr_head_approva_status,\r\n"
			+ "    nd.hod_approval_status,\r\n"
			+ "    ( SELECT TRIM(t$desc) FROM baan.thrmas016804 WHERE t$code = per.t$leavcd) as resiondesc,\r\n"
			+ "    per.T$LEAVDT as LAST_WORKING_DATE,\r\n"
			+ "    nd.initiate_date,\r\n"
			+ "    dept.t$desc AS dept,\r\n"
			+ "    desg.t$desc AS desg,\r\n"
			+ "    null\r\n"
			+ "FROM\r\n"
			+ "         baan.thrper001904 per\r\n"
			+ "    JOIN nodues_req_details nd ON per.t$empno = nd.empno\r\n"
			+ "    JOIN baan.thrmas020804  dept ON per.t$deptcd = dept.t$code\r\n"
			+ "    JOIN baan.thrmas007804  desg ON desg.t$code = per.t$desgcd where nd.HR_HEAD_APPROVA_STATUS=1")
	List<PendingReqInfo> getApprovedRequests();
	
	
	//Query(Resigned Employee Information in this code )
		@Query(nativeQuery = true, value = "select SEC_DESC from NODUES_SECTION_MASTER where id not in (select distinct(SEC_ID) \r\n"
				+ "from NODUES_SECTIONWISE_ND_DETAILS where REQ_ID=:reqid and status=1)")		
		List<String> getAllPendingDept(Long reqid);
				

		//Query(Pending Department QUery Section Wise )
		@Query(nativeQuery = true, value = "select distinct(B.sec_desc) from NODUES_SECTION_AUTHORITIES A,NODUES_SECTION_MASTER B  "
				+ "where A.SEC_ID=B.ID AND A.EMP_CODE=:empCode and A.SEC_ID not in (select distinct(SEC_ID) from NODUES_SECTIONWISE_ND_DETAILS where REQ_ID=:reqid and STATUS=1)")		
		List<String> getAllSectionspending(Long reqid,Long empCode);
		
		//Query(Approved Department QUery Section Wise )
		@Query(nativeQuery = true, value = "select distinct(B.sec_desc) from NODUES_SECTION_AUTHORITIES A,NODUES_SECTION_MASTER B  "
				+ "where A.SEC_ID=B.ID AND A.EMP_CODE=:empCode and A.SEC_ID in (select distinct(SEC_ID) from NODUES_SECTIONWISE_ND_DETAILS where REQ_ID=:reqid and STATUS=1)")		
		List<String> getAllSectionsApproved(Long reqid,Long empCode);
		
	
		
		@Query(nativeQuery = true,value="select count(*) from baan.thrper001804 where t$empno=:empCode")
		int  checkEmployeeCompany(Long empCode);
	
		
		
		
}
