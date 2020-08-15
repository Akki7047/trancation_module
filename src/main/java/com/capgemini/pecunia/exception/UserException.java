package com.capgemini.pecunia.exception;


/****************************
 *          @author          Satyam Sinha
 *          Description      It is a service class that provides the services for Transaction Exception
  *         Version             1.0
  *         Created Date    15-APR-2020
 ****************************/

public class UserException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UserException(String msg)
	{
		super(msg);
	}

}
