package com.cg.otms.exception;
//it is a class which extends the exception class
public class OtmsException extends Exception {

	//contructor with field
	public OtmsException(String message)
	{
		super(message);
	}

	public OtmsException()
	{
		super();
	}
}
