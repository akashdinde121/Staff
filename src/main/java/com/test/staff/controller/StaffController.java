package com.test.staff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.staff.entity.Staff;
import com.test.staff.service.StaffService;

@RestController
public class StaffController {


	@Autowired
	StaffService ss;



	@GetMapping("getdata")
	public List<Staff> getdata() {


		List<Staff> list=	ss.getdata();

		return list;
	}


	@PostMapping("insert")
	public String insertdata( @RequestParam  int staffid,String name,String profile,int salary,int experience) {

		String msg=	ss.insertdata(staffid, name, profile, salary, experience);

		return msg;		
	}

	@GetMapping("morethan")
	public List<Staff> getmorethansalary() {

		List<Staff> list	=ss.getmorethansalary();

		return list;
	}

	@GetMapping("getby")
	public List<Staff> getbyexp() {

		List<Staff> list =	ss.getbyexp();

		return list;
	}

	/*	@GetMapping("getid")
	List<Staff> getdataspecificid(int staffid) {

		List<Staff> list= ss.getdataspecificid(staffid);

		return list;
	}
	 */

	@GetMapping("getmax")
	public List<Staff> getmaxsalary() {

		List<Staff> list	=ss.getmaxsalary();

		return list;
	}

	@PutMapping("update")
	public String updatesalary(int staffid, int salary) {

		String msg=ss.updatesalary(staffid, salary);

		return msg;
	}

	@GetMapping("minexp")
	public List<Staff> getminexp() {

		List<Staff> list=	ss.getminexp();

		return list;
	}


	@GetMapping("gettr")
	public List<Staff> getTrainer() {

		List<Staff> list=	ss.getTrainer();

		return list;

	}

	@GetMapping("asdf")
	public List<Staff> getnotTrainer() {

		List<Staff> list=	ss.getnotTrainer();
		return list;
	}
}
