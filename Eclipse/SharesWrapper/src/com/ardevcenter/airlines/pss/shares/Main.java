package com.ardevcenter.airlines.pss.shares;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;







import com.copaair.webservices.*;

import org.apache.axis.message.*;

public class Main {

	public static void main(String[] args) throws Exception {
				
		SimpleDateFormat standardDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss" );
        String currentDate = standardDateFormat.format(new Date());
        
		System.out.println("Process started at: " + currentDate);
		SimpleSoapProxy rwyClient = new SimpleSoapProxy();
		// rwyClient.setEndpoint("http://idc-rwy/RunwayClient_25/Simple.asmx");
		rwyClient.setEndpoint("http://172.26.51.105/RunwayClient_25/Simple.asmx");
		MessageElement rs = rwyClient.connect("SHB", "Shares", 0).get_any()[0];

		String connID = rs.getElementsByTagName("ID").item(0).getFirstChild().toString();
		String connStatus = rs.getElementsByTagName("Status").item(0).getFirstChild().toString();

		System.out.println("Connection status: " + connStatus);
		System.out.println("Connection ID: " + connID);

		// ExecuteMessageMessage message = new ExecuteMessageMessage();
		// MessageElement[] messElementList = new MessageElement[1];
		// MessageElement messElem = new MessageElement();

		// SOAPElement command =
		// messElem.addChildElement("p").addChildElement("Command").addTextNode("QC/WEC/20");
		// command.setTextContent(("QC/WEC/20");
		// messElementList[0]= messElem;
		// "<p><Command>QC/WEC/20</Command></p>"
		// message.set_any(messElementList);
		String hmmTransactionName = "GenericCommandNew";
		List<String> results = new ArrayList<>();		
		results.add("Process started at: " + currentDate);
		
		String rsString = rwyClient.executeMessageHttpGet(hmmTransactionName, "<p><Command>QC/WEC/20</Command></p>", connID, 0);
		System.out.println("Response: " + rsString);
		results.add(rsString);
		
		Path path = Paths.get("c:\\Temp\\QueueInfo.txt");
		if (args.length >= 2 && args[1] != null) {
			path = Paths.get(args[1]);
		}

		if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			Files.write(path, results, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
			System.out.println("New File Created");
		} else {
			Files.write(path, results, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		}

		System.out.println("Done");

		rwyClient.disconnect("SHB", "Shares", connID, 0);
		// System.out.println("Connection ID: " + connID);
		// rwyClient.executeMessage(transactionName, message, connectionID,
		// timeOutRetries)

	}
}
