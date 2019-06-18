package com.conology.get;

import java.util.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainTest {

    public static void main(String[] args) throws Exception {
        String original = "rok.pusnik@conology.onmicrosoft.com:nZvnprWZ234FK4RjIDWk32E6";
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        String authString = "Authorization: Basic ".concat(encoded);
        String contentType = "Content-Type: application/json";
        String testAPIGET = "https://conology.atlassian.net/rest/api/2/issue/TRA-144";
    
	//java.io way of trying to authenticate
        URL url = new URL(testAPIGET);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization", "Basic "+encoded);

        //for POST
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write("grant_type=password&username=someusername&password=somepassword&scope=profile".getBytes()); 
	//line 30 is very wrong, Jira doesn't need this... but it does need something in its place?
        os.flush();
        os.close();
        // end POST
    	
        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }  
	//end of java.io way of trying to authenticate
	    
	    
      ObjectMapper mapper = new ObjectMapper();
      ReadWebPage page = new ReadWebPage();
      String content = page.getWebContent(testAPIGET);
      System.out.println(content);
	    /*
       * Post[] posts = mapper.readValue(content, Post[].class);
	     * System.out.println(posts[4].body);
       */
    }
    /*
     * send this curl to jira?
     * curl -D- -u rok.pusnik@conology.onmicrosoft.com:nZvnprWZ234FK4RjIDWk32E6 -X GET -H "Content-Type: application/json" "https://conology.atlassian.net/rest/api/2/issue/TRA-144"
     */
    
    //need to first grab active sprint, then all issues from the sprint, then data from specific issues
    
    
    /* it's HTML time
     * HTTP:      CRUD: 
     * POST       Create new entity 
     * GET        Read list or single entity
     * PUT        Update existing entity
     * DELETE     Delete an existing entity
     * 
     * HTTP response status codes
     * 100-199 - informational
     * 200-299 - successful
     * 300-399 - redirection
     * 400-499 - client error
     * 500-599 - server error
     * 
     * MIME content types
     * Multi-purpose Internet Mail-Extension
     * type/sub-type 
     *
     * text/html
     * text/plain
     * 
     * application/json
     * application/xml
     */

}
