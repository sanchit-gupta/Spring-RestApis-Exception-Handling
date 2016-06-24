package main.globalexception;


import main.enums.ErrorMessageEnum;

public class BadRequestException extends GenericException{

	private static final long serialVersionUID = 3991735101125997923L;

	public BadRequestException() {
		super(ErrorMessageEnum.BAD_REQUEST);
	}

}
