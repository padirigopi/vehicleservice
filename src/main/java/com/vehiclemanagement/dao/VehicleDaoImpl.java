package com.vehiclemanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehiclemanagement.model.Vehicle;

@Repository("vehicleDao")
public class VehicleDaoImpl implements VehicleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Vehicle> getAllVehicles() {
		Session session = sessionFactory.openSession();
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		try {
			vehicleList = session.createQuery("From Vehicle").list();
			session.close();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

	public void saveVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		try {
			session.saveOrUpdate(vehicle);
			session.flush();
			session.close();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
	}

	public Vehicle getVehicle(String vehicleID) {
		Session session = sessionFactory.openSession();
		List<Vehicle> vehicleList = null;
		Query query = session.createQuery("From Vehicle where vehicleID=:vid");
		query.setParameter("vid", vehicleID);
		try {
			vehicleList = (List<Vehicle>) query.list();
			System.out.println(vehicleList+" "+vehicleList.size());
			if(vehicleList.size() !=0) {
				return vehicleList.get(0);
			}
			session.close();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		return new Vehicle();
	}

	public void deleteVehicle(String vehicleID) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("DELETE Vehicle where vehicleID=:vid");
		query.setParameter("vid", vehicleID);
		try {
			query.executeUpdate();
			session.close();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
	}

}
