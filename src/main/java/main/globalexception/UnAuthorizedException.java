package main.globalexception;


import main.enums.ErrorMessageEnum;

public class UnAuthorizedException extends GenericException{
	
	private static final long serialVersionUID = 3991732101125997923L;

	public UnAuthorizedException() {
		super(ErrorMessageEnum.NOT_AUTHORIZED);
	}

}
