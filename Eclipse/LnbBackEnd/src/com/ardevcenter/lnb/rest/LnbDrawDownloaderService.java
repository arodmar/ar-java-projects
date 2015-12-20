package com.ardevcenter.lnb.rest;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.ardevcenter.drawmanager.lnb.LnbDrawAdapter;
import com.ardevcenter.drawmanager.lnb.LnbDrawRawEntity;
import com.ardevcenter.utilities.urltemplategenerator.UrlGenerator;
import com.google.gson.Gson;



@Path("lnbdrawdownloader")
public class LnbDrawDownloaderService {
		
	@GET
	// @Path("/") @MatrixParam, @HeaderParam, @CookieParam, @FormParam,
	// @QueryParam, @PathParam
	// @Produces({"application/xml; qs=0.9", "application/json"})
	@Path("/{year}")
	@Produces("application/json")
	public Response getDrawsByYear(@PathParam("year") Integer year,@Context final HttpServletRequest req, @Context final HttpServletResponse resp) throws Exception {

		GenericResponseMessage<List<LnbDrawRawEntity>> rsp = null;
		try {
			String lnbUrlForSpecificYear = req.getSession().getServletContext().getInitParameter("lnbUrlForSpecificYear");
			lnbUrlForSpecificYear = String.format(lnbUrlForSpecificYear, year);
			
			UrlGenerator ug = new UrlGenerator();
			ug.setUrlPattern(lnbUrlForSpecificYear);
			List<String> urls = ug.generateUrls();
			
			LnbDrawAdapter da = new LnbDrawAdapter(urls);
			List<LnbDrawRawEntity> drawInfo = da.getLnbDrawData();
			rsp = new GenericResponseMessage<>(true, drawInfo);			
					
		} catch (Exception ex) {
			String[] errors = {"Error generating the response", ex.getMessage()};
			rsp = new GenericResponseMessage<>(false, null,null, errors);
		}
		String jsonResp = new Gson().toJson(rsp);
		return Response.status(200).entity(jsonResp).build();
	}
	
	
	@GET
	// @Path("/") @MatrixParam, @HeaderParam, @CookieParam, @FormParam,
	// @QueryParam, @PathParam
	// @Produces({"application/xml; qs=0.9", "application/json"})
	@Path("/{year}/{month}")
	@Produces("application/json")
	public Response getDrawsByYearAndMonth(@PathParam("year") Integer year,@PathParam("month") Integer month,@Context final HttpServletRequest req, @Context final HttpServletResponse resp) throws Exception {

		GenericResponseMessage<List<LnbDrawRawEntity>> rsp = null;
		try {
			String lnbUrlForSpecificMonth = req.getSession().getServletContext().getInitParameter("lnbUrlForSpecificMonth");
			lnbUrlForSpecificMonth = String.format(lnbUrlForSpecificMonth, year, month);
			LnbDrawAdapter da = new LnbDrawAdapter(lnbUrlForSpecificMonth);
			List<LnbDrawRawEntity> drawInfo = da.getLnbDrawData();
			rsp = new GenericResponseMessage<>(true, drawInfo);
			
					
		} catch (Exception ex) {
			String[] errors = {"Error generating the response", ex.getMessage()};
			rsp = new GenericResponseMessage<>(false, null,null, errors);
		}
		String jsonResp = new Gson().toJson(rsp);
		return Response.status(200).entity(jsonResp).build();
	}

}
