package bulksms;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMS {
	public static void main(String[] args) {
		SMS sms = new SMS();
		String message = "Hello this is ganu";
		//If you want send bulk SMS enter the numbers with comma -EX: 1234567890,1234567890
		String numbers = "9543510240";
		sms.sendSms(message, numbers);
	}
	public void sendSms(String message,String numbers) {
		String api = "QfZsLYmnKeu56RtG0MC_vWjow1ycBiAFVlOa4pUS8PTXEzDI37_HNUbfRdrsc73Auv1CtIPHaiVhZYwE8-12D/2";
		String route = "v3";
		String sender_id="TXTIND";
		String language="english";
		String flash="0";	
		String encoding = "UTF-8";		
		try {
			//Creating QueryString 
			String queryString ="authorization=" + URLEncoder.encode(api, encoding)
	        + "&route=" + URLEncoder.encode(route, encoding)
	        + "&sender_id=" + URLEncoder.encode(sender_id, encoding)
	        + "&message=" + URLEncoder.encode(message, encoding)
	        + "&language=" + URLEncoder.encode(language, encoding)
	        + "&flash=" + URLEncoder.encode(flash, encoding)
	        + "&numbers=" + URLEncoder.encode(numbers, encoding);
			
			//URL Object Creation 
			URL url = new URL("https://www.fast2sms.com/dev/bulkV2?"+queryString);			
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);	
			//Store the Response into the Buffered Reader
		    BufferedReader rd = new BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
		    //Move the result to a String
		    String result = rd.readLine();		   
		    rd.close();
		    
		    //Validate the result and display the output in console.
		    if(result == null) {
		        System.out.println("No response received");
		      }
		      else if(result.startsWith("{\"return\":true")) {
		        System.out.println("Message sent successfully");
		      } 
		      else {
		        System.out.println("Error - " + result);
		      }
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}	
	
}