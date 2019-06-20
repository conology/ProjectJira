package com.conology.get;

import com.conology.server.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Issue implements IIssue {
	int timeSpent;
	int timeEstimate;
	String description;
	String id;  //integer... typically
	String key; //TRA-num
	Person assignee;
	int timeLeft=0;

}