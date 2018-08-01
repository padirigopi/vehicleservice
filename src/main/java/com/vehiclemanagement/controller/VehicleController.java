package com.vehiclemanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vehiclemanagement.dao.VehicleDao;
import com.vehiclemanagement.model.Vehicle;


/**
 * Handles requests for the Employee service.
 */
@Controller
public class VehicleController {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private VehicleDao vehicleDao;
	
	@RequestMapping(value = VehicleURIConstants.GET_VEHICLE, method = RequestMethod.GET)
	public @ResponseBody Vehicle getVehicle(@PathVariable("id") String vID) {
		logger.info("Start getVehicle. ID="+vID);
		Vehicle vehicleList = vehicleDao.getVehicle(vID);
		return vehicleList;
	}
	
	@RequestMapping(value = VehicleURIConstants.GET_ALL_VEHICLES, method = RequestMethod.GET)
	public @ResponseBody List<Vehicle> getAllVehicles() {
		logger.info("Start getAllVehicles.");
		List<Vehicle> vehicles = vehicleDao.getAllVehicles();
		return vehicles;
	}
	
	@RequestMapping(value = VehicleURIConstants.CREATE_VEHICLE, method = RequestMethod.POST)
	public @ResponseBody Vehicle createVehicle(@RequestBody Vehicle veh,HttpServletResponse response) {
		logger.info("Start createVehicle.");
		vehicleDao.saveVehicle(veh);
		response.setStatus(HttpServletResponse.SC_CREATED);
		return veh;
	}
	
	@RequestMapping(value = VehicleURIConstants.DELETE_VEHICLE, method = RequestMethod.PUT)
	public @ResponseBody Vehicle deleteVehicle(@PathVariable("id") String vID, HttpServletResponse response) {
		System.out.println("Delete Vhicle");
		logger.info("Start deleteVehicle.");
		Vehicle vehicle = vehicleDao.getVehicle(vID);
		vehicleDao.deleteVehicle(vID);
		return vehicle;
	}
	
}

