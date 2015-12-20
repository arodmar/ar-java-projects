package com.ardevcenter.lnbexplorer.ui;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

//import com.ardevcenter.lnbexplorer.entities.LnbDraw;
import com.ardevcenter.lnbexplorer.data.jdo.entities.LnbDraw;
import com.ardevcenter.lnbexplorer.logic.DrawAnalyzer;
import com.ardevcenter.lnbexplorer.logic.DrawManager;
//import com.ardevcenter.numbermanager.LnbNumberParser;
import com.ardevcenter.utilities.DateFunctions;

@SuppressWarnings("serial")
public class GetDrawRangeDataServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		String initialDate = req.getParameter("id");
		String finalDate = req.getParameter("fd");
		boolean analyzeAll =  req.getParameter("all")!=null?true:false;
		List<LnbDraw> drawData =  DrawManager.getDrawData(DateFunctions.parseDateFromString(initialDate),DateFunctions.parseDateFromString(finalDate),true);
		//resp.getWriter().println(drawData);	
		int index = 0;
		for (LnbDraw draw : drawData) {
			index +=1;
			resp.getWriter().println(index  + ") "+ draw.getDrawDate() + " " + draw.getDrawType() + " " +  draw.getFirstNumber()+ " " +   draw.getSecondNumber()+ " " +  draw.getThirdNumber());
		}
		
		resp.getWriter().println();
		resp.getWriter().println("Frecuency:");
		
		Map<String, Integer> map = DrawAnalyzer.analyzeDraws(drawData,analyzeAll);
		 for (int i = 0; i < 10; i++) {
	        	String number = String.valueOf(i);
	        	if (map.containsKey(number)){
	        		resp.getWriter().println(number + ": " + String.valueOf(map.get(number)));	
	        	}
	        	else{
	        		resp.getWriter().println(number + ": 0");
	        	}
	        }
		 
			resp.getWriter().println();
			resp.getWriter().println("Last Show Time:");
			
		 map = DrawAnalyzer.getLastShowTime(drawData);
		 for (int i = 0; i < 10; i++) {
	        	String number = String.valueOf(i);
	        	if (map.containsKey(number)){
	        		resp.getWriter().println(number + ": " + String.valueOf(map.get(number)));	
	        	}
	        	else{
	        		resp.getWriter().println(number + ": 0");
	        	}
	        }
	}	
	
}
