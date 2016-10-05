package com.pvt.tracker.beans.enums;

public enum StateType {

	ACTIVE("Active"),
	INACTIVE("Inactive"),
	DELETED("Deleted"),
	LOCKED("Locked");
	
	private String state;
	
	private StateType (final String state){
		this.state = state;
	}
	
	public String getState(){
		return this.state;
	}

	@Override
	public String toString(){
		return this.state;
	}

	public String getName(){
		return this.name();
	}
}
