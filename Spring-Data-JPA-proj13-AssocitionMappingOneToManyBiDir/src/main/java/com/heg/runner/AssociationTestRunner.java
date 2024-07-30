package com.heg.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.heg.entity.Person;
import com.heg.entity.PhoneNumber;
import com.heg.service.IPersonMgmtService;

@Component
public class AssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Prepare Parent Object Having associated child Object
		
	/*	PhoneNumber ph1=new PhoneNumber(9999999999l, "airtel", "office");
		PhoneNumber ph2=new PhoneNumber(9888888888l, "Jio", "office -2 ");
		PhoneNumber ph3=new PhoneNumber(9777777777l, "Vodafone", "Residence");
		PhoneNumber ph4=new PhoneNumber(9666666666l, "Idea", "Permanent Residence");		
		Set<PhoneNumber> phoneSet=Set.of(ph1,ph2,ph3,ph4);
		
		//Parent Object		
		Person person1=new Person("Rajesh", "Hedarabad");

		
		//Parent To Child
		ph1.setPerson(person1);
		ph2.setPerson(person1);
		ph3.setPerson(person1);
		ph4.setPerson(person1);
		
		//Child To Parent		
		person1.setContactDetails(phoneSet);		
		
		//Invoke Service method		
		System.out.println(service.savePerson(person1));*/
		
		//===========LOAD OPERATION PARENT TO CHILD
		
		service.fetchByPerson().forEach(per->{
			System.out.println("PARENT  :::" +per);
			Set<PhoneNumber> childs=per.getContactDetails();
			childs.forEach(ph->{
				System.out.println("CHILD " +ph);
			});
			
		});
		
		
		//service.fetchByPerson().forEach(per->{System.out.println(per);});
		
		

	}

}
