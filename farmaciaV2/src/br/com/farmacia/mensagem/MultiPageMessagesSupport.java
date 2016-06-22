package br.com.farmacia.mensagem;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MultiPageMessagesSupport implements PhaseListener{


	private static final long serialVersionUID = 2061163429379512661L;
	
	private static final String sessionToken = "MULTI_PAGE_MESSAGES_SUPPORT";

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void beforePhase(PhaseEvent event) {
		if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
			FacesContext facesContext = event.getFacesContext();
			restoreMessages(facesContext);
		}
	}

	public void afterPhase(PhaseEvent event) {
		if ((event.getPhaseId() != PhaseId.APPLY_REQUEST_VALUES)
				&& (event.getPhaseId() != PhaseId.PROCESS_VALIDATIONS)
				&& (event.getPhaseId() != PhaseId.INVOKE_APPLICATION)) {
			return;
		}
		FacesContext facesContext = event.getFacesContext();
		saveMessages(facesContext);
	}

	private int saveMessages(FacesContext facesContext) {
		Set messages = new HashSet();
		for (Iterator i = facesContext.getMessages(null); i.hasNext();) {
			FacesMessage msg = (FacesMessage) i.next();
			messages.add(msg);
			i.remove();
		}

		if (messages.size() == 0) {
			return 0;
		}
		Map sessionMap = facesContext.getExternalContext().getSessionMap();
		Set existingMessages = (Set) sessionMap
				.get("MULTI_PAGE_MESSAGES_SUPPORT");
		if (existingMessages != null)
			existingMessages.addAll(messages);
		else {
			sessionMap.put("MULTI_PAGE_MESSAGES_SUPPORT", messages);
		}
		return messages.size();
	}

	private int restoreMessages(FacesContext facesContext) {
		Map sessionMap = facesContext.getExternalContext().getSessionMap();
		Set<FacesMessage> messages = (Set<FacesMessage>) sessionMap.remove("MULTI_PAGE_MESSAGES_SUPPORT");

		if (messages == null)
			return 0;
		int restoredCount = messages.size();

		Set facesContextMessages = new HashSet();
		for (Iterator i = facesContext.getMessages(null); i.hasNext();) {
			FacesMessage msg = (FacesMessage) i.next();
			facesContextMessages.add(msg);
			i.remove();
		}

		for (FacesMessage facesMessage : messages) {
			if (!(facesContextMessages.contains(facesMessage)))
				facesContext.addMessage(null, facesMessage);
		}
		return restoredCount;
	}

}