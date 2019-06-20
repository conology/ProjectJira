package com.conology.get;

//import java.util.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Main {

    @SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
    	String email = "rok.pusnik@conology.onmicrosoft.com", token= "nZvnprWZ234FK4RjIDWk32E6";
    	String jqlQueryURL = "https://conology.atlassian.net/rest/api/2/search?jql=sprint%20in%20openSprints()%20and%20sprint%20not%20in%20futureSprints()";
    	HttpResponse<JsonNode> response = Unirest.get(jqlQueryURL).basicAuth(email, token).header("Accept","application/json").asJson();
       	System.out.println(response.getBody());
    	
    	//sauce for not working example: https://stackoverflow.com/questions/45687588/java-post-request-to-get-token-from-web-service
    	    
    	//just reading from existing JSON file
    	ObjectMapper mapper = new ObjectMapper();
    	ReadWebPage page = new ReadWebPage();
    	String content = page.getWebContent(jqlQueryURL);
    	
    	Sprint sprint = mapper.readValue(content, Sprint.class);
    	
    }
    
    
    /*
     * String encoded = Base64.getEncoder().encodeToString((email.concat(":").concat(token)).getBytes());
     * String authString = "Authorization: Basic ".concat(encoded);
     * String contentType = "Content-Type: application/json";
     * String testAPIGET = "https://conology.atlassian.net/rest/agile/1.0/sprint/8";
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