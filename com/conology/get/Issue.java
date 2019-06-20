package com.conology.get;

import com.conology.server.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Issue implements IIssue {
	int timeSpent=0;
	int timeEstimate=0;
	String description = "";
	String id = "";  //integer... typically
	String key = ""; //TRA-num
	Person assignee = null;
	int timeLeft=0;	
}
