package com.conology.server;
import com.conology.get*;

public interface Person extends IIssue {
	public static int id=0;
	public static String name="";
	public static int sumEstimate=0;
	public static int sumRemainingEffort=0;
	boolean isUnderworked();
	boolean isOverworked();
	//TODO: maybe add way to get picture too
}