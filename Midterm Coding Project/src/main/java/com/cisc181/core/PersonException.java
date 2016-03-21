package com.cisc181.core;

@SuppressWarnings("serial")
public class PersonException extends Exception {
	
	private Person p;
	
	public PersonException(Person person){
		this.p= person;
	}
	
	public Person getPerson(){
		return this.p;
	}
}
