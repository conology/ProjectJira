package com.conology.get;

import java.util.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {

    public static void main(String[] args) throws Exception {
    	String original = "rok.pusnik@conology.onmicrosoft.com:nZvnprWZ234FK4RjIDWk32E6";
    	String encoded = Base64.getEncoder().encodeToString(original.getBytes());

    	
    	//just reading from existing JSON file
    	ObjectMapper mapper = new ObjectMapper();
    	ReadWebPage page = new ReadWebPage();
    	String content = page.getWebContent("http://jsonplaceholder.typicode.com/posts");
    	
	    Post[] posts = mapper.readValue(content, Post[].class);
	    System.out.println(posts[4].body);
    }
    //TOKEN = rok.pusnik@conology.onmicrosoft.com:nZvnprWZ234FK4RjIDWk32E6
    
    /*
     * send this curl to jira?
     * curl -D- -X GET -H "Authorization: Basic ZnJlZDpmcmVk" -H 
       "Content-Type: application/json" "https://your-domain.atlassian.net/rest/api/2/issue/QA-31"
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
