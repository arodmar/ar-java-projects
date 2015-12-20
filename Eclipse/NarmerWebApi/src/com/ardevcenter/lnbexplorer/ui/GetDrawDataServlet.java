package com.ardevcenter.lnbexplorer.ui;

import java.io.IOException;
import javax.servlet.http.*;

//import com.ardevcenter.lnbexplorer.entities.LnbDraw;
import com.ardevcenter.lnbexplorer.data.jdo.entities.LnbDraw;
import com.ardevcenter.lnbexplorer.logic.DrawManager;
//import com.ardevcenter.numbermanager.LnbNumberParser;
import com.ardevcenter.utilities.DateFunctions;

@SuppressWarnings("serial")
public class GetDrawDataServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		String date = req.getParameter("date");	
		LnbDraw drawData =  DrawManager.getDrawData(DateFunctions.parseDateFromString(date));
		resp.getWriter().println(drawData);	
	}	
	
}
