package com.test.staff.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.staff.entity.Staff;

@Repository
public class StaffDao {

	@Autowired
	SessionFactory sf;

	public List<Staff> getdata() {

		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);

		List<Staff> list =criteria.list();

		return list;

	}

	public String insertdata(int staffid,String name,String profile,int salary,int experience) {

		Session session = sf.openSession();
		Transaction tr= session.beginTransaction();
		Staff st= new Staff();
		st.setStaffid(staffid);
		st.setName(name);
		st.setProfile(profile);
		st.setSalary(salary);
		st.setExperience(experience);
		session.save(st);
		tr.commit();
		session.close();
		return " true ";

	}

	public List<Staff> getmorethansalary() {

		Session session= sf.openSession();

		Criteria criteria =session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary",20000));
		List<Staff> list = criteria.list();

		session.close();
		return list;


	}

	public List<Staff> getbyexp() {

		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", 10, 20));
		List<Staff> list= criteria.list();
		session.close();

		return list;
	}


	/*	public List<Staff> getdataspecificid(int staffid) {

		Session session = sf.openSession();
		Criteria criteria= session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("staffid", staffid));

		List<Staff> list=criteria.list();
		session.close();
		return list;
	}
	 */

	public List<Staff> getmaxsalary() {

		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.addOrder(Order.desc("salary"));
		criteria.setMaxResults(1);

		List<Staff> list= criteria.list();
		int id;
		String str= null;
		String str1=null;
		int salary;
		int experience;

		for (Staff staff : list) {

			id=staff.getStaffid();
			str=staff.getName();
			str1=staff.getProfile();
			salary=staff.getSalary();
			experience=staff.getExperience();

		}
		session.close();
		return list;

	}

	public String updatesalary(int staffid , int salary) {

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Staff st= new Staff();
		st.setStaffid(staffid);
		st.setSalary(salary);
		session.update(st);
		tr.commit();
		session.close();

		return "data update";

	}

	public List<Staff> getminexp() {

		Session session =sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.addOrder(Order.asc("experience"));

		criteria.setMaxResults(1);
		List<Staff> list =criteria.list();
		String name=null;

		for (Staff staff : list) {

			name=staff.getName();
		}
		session.close();
		return list;
	}

	public List<Staff> getTrainer() {

		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("profile", "trainer"));

		List<Staff> list = criteria.list();

		session.close();
		return list;
	}


	public List<Staff> getnotTrainer() {

		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", "trainer"));

		List<Staff> list = criteria.list();

		session.close();
		return list;
	}
	
	
	
}
