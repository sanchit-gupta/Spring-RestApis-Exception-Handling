package main.globalexception;


import main.enums.ErrorMessageEnum;

public class UserBlockedException extends GenericException{
	
	private static final long serialVersionUID = 3991732101125997923L;

	public UserBlockedException() {
		super(ErrorMessageEnum.BLOCKED);
	}

}
