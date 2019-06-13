package com.conology.server;

public interface Person {
	public static int id=0;
	public static String name="";
	public static int sumEstimate=0;
	public static int sumRemainingEffort=0;
	boolean isUnderworked();
	boolean isOverworked();
	//TODO: maybe add way to get picture too
}