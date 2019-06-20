package com.conology.get;

import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Sprint implements ISprint {
	ArrayList<Issue> issues;
	String teamName;
	Date startDate, endDate;
	Issue[] issueList;
}
