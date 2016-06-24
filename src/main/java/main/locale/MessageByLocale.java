package main.locale;

import main.enums.ErrorMessageEnum;
import main.enums.SuccessMessageEnum;
import main.globalexception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageByLocale {

	@Autowired
	private MessageSource messageSource;

	public Locale getLocale() {
		return LocaleContextHolder.getLocale();
	}

	public String getSuccessMessage(SuccessMessageEnum successMsg) {
		return messageSource.getMessage(successMsg.getMessageCode(), successMsg.getArgs(), getLocale());
	}
	public String getErrorMessage(ErrorMessageEnum errorMessageEnum) {
		return messageSource.getMessage(errorMessageEnum.getMessageCode(), errorMessageEnum.getArgs(), getLocale());
	}
	public String getMessage(String msg) {
		return messageSource.getMessage(msg, null, getLocale());
	}

	public String getMessage(GenericException e) {
		return messageSource.getMessage(GenericException.errorMsg.getMessageCode(), GenericException.errorMsg.getArgs(),
				e.message != null ? e.message : GenericException.errorMsg.getHttpStatus().getReasonPhrase(), getLocale());
	}
}
