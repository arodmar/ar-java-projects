package com.ardevcenter.lnbexplorer.rest;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;



import java.util.TimeZone;

//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ardevcenter.lnbexplorer.data.jdo.entities.LnbDraw;
import com.ardevcenter.lnbexplorer.logic.DrawManager;
import com.ardevcenter.utilities.DateFunctions;
import com.google.gson.*;


@Path("/draws")
public class Draws {
	
	@POST
	@Path("/add")
	//@Produces({"application/xml; qs=0.9", "application/json"})
	@Produces("application/json")
	public Response addCurrentMonthDraws(@Context final HttpServletRequest req,  @Context final HttpServletResponse resp) throws Exception {
		String defaultTimeZone = req.getSession().getServletContext().getInitParameter("defaultTimeZone");
		Calendar cal =  GregorianCalendar.getInstance(TimeZone.getTimeZone(defaultTimeZone));		
		Integer initialYear=  cal.get(Calendar.YEAR);
		Integer initialMonth = cal.get(Calendar.MONTH) + 1;
		return addDraws(initialYear,initialMonth,initialYear,initialMonth,req,resp);
	}

 
	@GET
	@Path("/add/{year}")
	//@Produces({"application/xml; qs=0.9", "application/json"})
	@Produces("application/json")
	public Response addDrawsByYear(@PathParam("year") Integer year,  @Context final HttpServletRequest req,  @Context final HttpServletResponse resp) throws Exception {
		String defaultTimeZone = req.getSession().getServletContext().getInitParameter("defaultTimeZone");
		Calendar cal =  GregorianCalendar.getInstance(TimeZone.getTimeZone(defaultTimeZone));
		
		Integer finalMonth = cal.get(Calendar.YEAR)== year? cal.get(Calendar.MONTH) + 1:12;
		return addDraws(year,1, year,finalMonth,req,resp); 
	}
	
	@GET
	@Path("/add/{year}/{month}")	
	//@Produces({"application/xml; qs=0.9", "application/json"})
	@Produces("application/json")
	public Response addDrawsByMonth(
			@PathParam("year") Integer year,
			@PathParam("month") Integer month,  
			@Context final HttpServletRequest req,  
			@Context final HttpServletResponse resp) throws Exception {
		
		return addDraws(year,month,year,month,req,resp);
 
	}
	
	@GET
	@Path("/add/{initialYear}/{initialMonth}/{finalYear}/{finalMonth}")	
	//@Produces({"application/xml; qs=0.9", "application/json"})
	@Produces("application/json")
	public Response addDraws(
			@PathParam("initialYear") Integer initialYear,
			@PathParam("initialMonth") Integer initialMonth,  
			@PathParam("finalYear") Integer finalYear,
			@PathParam("finalMonth") Integer finalMonth,  
			@Context final HttpServletRequest req,  
			@Context final HttpServletResponse resp) throws Exception {
		
		List<LnbDraw> drawData = DrawManager.addNewDrawData(initialYear,finalYear,initialMonth,finalMonth);
		Gson gs = new Gson();		
		return Response.status(200).entity(gs.toJson(drawData)).build();
		//return Response.status(200).entity(drawData.get(0)).build();
	}
	
	@GET
	@Path("/get")	
	//@Produces({"application/xml; qs=0.9", "application/json"})
	@Produces("application/json")
		public String getDraws(@PathParam("date") String date)
				throws IOException {
			LnbDraw drawData =  DrawManager.getDrawData(DateFunctions.parseDateFromString(date));
			Gson gs = new Gson();
			return gs.toJson(drawData);
		}	
	
 
}