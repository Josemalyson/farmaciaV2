package br.com.farmacia.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import br.com.farmacia.util.FacesUtil;

public class ExceptionHandlerCustom extends ExceptionHandlerWrapper {
	private static final String ERRO_MSG = "erroMsg";
	private static final String PAGE_500 = "/500";
	public static final String FACES_REDIRECT = "?faces-redirect=true";

	private ExceptionHandler exceptionHandler;

	public ExceptionHandlerCustom(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	public ExceptionHandler getWrapped() {
		return this.exceptionHandler;
	}

	public void handle() throws FacesException {
		for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext();) {
			ExceptionQueuedEvent exceptionQueuedEvent = i.next();
			ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext) exceptionQueuedEvent.getSource();
			Throwable throwable = exceptionQueuedEventContext.getException();

			if (throwable instanceof Throwable) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				NavigationHandler navigationHandler = facesContext
						.getApplication().getNavigationHandler();
				try {
					String statckTrace = getStackTrace(throwable);
					ExcecaoTratador.tratar(statckTrace);
					
					FarmaciaException be = getBusinessException(throwable);
					if (be != null) {
						List<String> msgList = be.getMensagemList(); 
						if (msgList == null) {
							FacesUtil.adicionarErro(be.getMessage());
						} else {
							for (String msg : msgList) {
								FacesUtil.adicionarErro(msg);
							}
						}
					} else {
						FacesUtil.setSessionAttribute(ERRO_MSG, statckTrace);
						navigationHandler.handleNavigation(facesContext, null, PAGE_500 + FACES_REDIRECT);
						facesContext.renderResponse();
					}
				} finally {
					i.remove();
				}
			}
		}

		getWrapped().handle();
	}
	
	private FarmaciaException getBusinessException(Throwable throwable) {
		if (throwable instanceof FarmaciaException) {
			return (FarmaciaException) throwable;
		} else if (throwable.getCause() != null) {
			return getBusinessException(throwable.getCause());
		} else {
			return null;
		}
	}
	
	private String getStackTrace(Throwable exception) {
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);

		exception.printStackTrace(printWriter); //NOSONAR
		
		return writer.toString();
	}
}