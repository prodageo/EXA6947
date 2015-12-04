package org.prodageo.EXA6927B ;

import org.apache.camel.builder.RouteBuilder ;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Endpoint;
import org.apache.camel.Message;

import java.util.Calendar ;
import java.text.SimpleDateFormat;

public class MyMailRouteBuilder extends RouteBuilder
{
 @Override
 public void configure() throws Exception {
	
	String theSmtpServer = "smtp://smtp.syrhano.net:587" ;
	//  "smtp://smtp.gmail.com" //GMAIL
	String theRegisteredUser = "moi@insa-rouen.fr";
	// String theRegisteredUser = "moi"; // gmail
	String thePassword = "cavapasnon" ;

	final String HOST_MAIL_OPTIONS =
	theSmtpServer
	+ "?username=" + theRegisteredUser + "&password=" + thePassword
	+ "&mail.smtp.auth=true"
	+ "&mail.smtp.starttls.enable=true"
	+ "&from=" +  theRegisteredUser
	+ "&subject=test camel"
	+ "&to=" +  theRegisteredUser
	+ "&debugMode=true";

	final String dateDuJour = 
               new SimpleDateFormat("dd/MM/yy HH:mm:ss")
			.format(Calendar.getInstance().getTime());

	from("file:/tmp/input").to(HOST_MAIL_OPTIONS);
  }
}
