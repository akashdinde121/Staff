package com.test.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.staff.dao.StaffDao;
import com.test.staff.entity.Staff;
@Service
public class StaffService {


	@Autowired
	StaffDao sd;

	public List<Staff> getdata() {


		List<Staff> list= sd.getdata();

		return list;
	}


	public String insertdata(int staffid,String name,String profile,int salary,int experience) {

		String msg=	sd.insertdata(staffid, name, profile, salary, experience);

		return msg;

	}

	public List<Staff> getmorethansalary() {

		List<Staff> list	=sd.getmorethansalary();

		return list;
	}



	public List<Staff> getbyexp() {

		List<Staff> list=	sd.getbyexp();

		return list;	

	}

	/*	public List<Staff> getdataspecificid(int staffid) {

		List<Staff> list= sd.getdataspecificid(staffid);

		return list;

	}
	 */

	public List<Staff> getmaxsalary() {

		List<Staff> list=	sd.getmaxsalary();

		return list;
	}



	public String updatesalary(int staffid , int salary) {

		String msg	=sd.updatesalary(staffid, salary);

		return msg;
	}

	public List<Staff> getminexp() {

		List<Staff> list=	sd.getminexp();

		return list;
	}


	public List<Staff> getTrainer() {

		List<Staff> list=	sd.getTrainer();
		return list;
	}

	public List<Staff> getnotTrainer() {

		List<Staff> list=	sd.getnotTrainer();
		return list;
	}

}
