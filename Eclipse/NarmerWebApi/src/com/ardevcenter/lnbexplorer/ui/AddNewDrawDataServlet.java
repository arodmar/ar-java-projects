package com.ardevcenter.lnbexplorer.ui;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.*;

//import com.ardevcenter.lnbexplorer.entities.LnbDraw;
import com.ardevcenter.lnbexplorer.data.jdo.entities.LnbDraw;
import com.ardevcenter.lnbexplorer.logic.DrawManager;

//import com.ardevcenter.numbermanager.LnbNumberParser;

@SuppressWarnings("serial")
public class AddNewDrawDataServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");

		// Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
		Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
		cal.get(Calendar.MONTH);

		// If no parameter, use current date as default
		Integer initialYear = req.getParameter("iy") != null ? Integer.parseInt(req.getParameter("iy")) : cal.get(Calendar.YEAR);
		Integer initialMonth = req.getParameter("im") != null ? Integer.parseInt(req.getParameter("im")) : cal.get(Calendar.MONTH) + 1;
		Integer finalYear = req.getParameter("fy") != null ? Integer.parseInt(req.getParameter("fy")) : cal.get(Calendar.YEAR);
		Integer finalMonth = req.getParameter("fm") != null ? Integer.parseInt(req.getParameter("fm")) : cal.get(Calendar.MONTH + 1);

		List<LnbDraw> drawData = DrawManager.addNewDrawData(initialYear, finalYear, initialMonth, finalMonth);
		for (LnbDraw draw : drawData) {
			resp.getWriter().println(draw);
		}
	}

}
