package com.ardevcenter.utilities.api;

//import java.util.ArrayList;
import java.util.List;
//import java.util.TimeZone;





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

import com.ardevcenter.utilities.urltemplategenerator.UrlGenerator;
import com.google.gson.Gson;

@Path("url/urlgenerator")
public class UrlTemplateGenerator {

	@GET	
	@Path("/help")
	@Produces("text/html")
	public Response getHelp(@Context final HttpServletRequest req, @Context final HttpServletResponse resp) throws Exception {
		String html = "<h1>Help</h1>" + 
					"<p>url.com[1-12][12-17]</p>";
		return Response.status(200).entity(html).build();
	}
	
	@GET	
	@Path("/{urlpattern}")
	@Produces("application/json")
	public Response getUrlsFromPattern_GET(@PathParam("urlpattern") String urlPattern, @Context final HttpServletRequest req, @Context final HttpServletResponse resp) throws Exception {
		return getUrlsFromPattern(urlPattern, req, resp );
	}
	
	@POST
	@Produces("application/json")
	public Response getUrlsFromPattern_POST(@Context final HttpServletRequest req,
			@Context final HttpServletResponse resp) throws Exception {
		String postedData = req.getParameter("urlpattern");
		return getUrlsFromPattern(postedData, req, resp );
	}
	
	
	public Response getUrlsFromPattern(String urlPattern, @Context final HttpServletRequest req,
			@Context final HttpServletResponse resp) throws Exception {

		// String defaultTimeZone =
		// req.getSession().getServletContext().getInitParameter("defaultTimeZone");
		GenericResponseMessage<List<String>> responseMessage = null;
		try {
			UrlGenerator gen = new UrlGenerator();
			gen.setUrlPattern(urlPattern);
			List<String> generatedUrls = gen.generateUrls();
			responseMessage = new GenericResponseMessage<List<String>>(true, generatedUrls);
		} catch (Exception ex) {
			String[] errors = {"Error generating the response", ex.getMessage()};
			responseMessage = new GenericResponseMessage<List<String>>(false, null, null, errors);
		}

		String jsonResp = new Gson().toJson(responseMessage);
		return Response.status(200).entity(jsonResp).build();
	}

}
