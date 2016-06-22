package br.com.farmacia.generics;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "genericConverter")
public class GenericConverter implements Converter {

	private int index;
	private String clientId;

	@SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {
		if ("-1".equals(value)) {
			return null;
		}
		

		List<Object> items = new ArrayList<Object>();
		List<UIComponent> uicompList = uicomp.getChildren();
		for (UIComponent comp : uicompList) {
			if (comp instanceof UISelectItems) {
				items.addAll((List<Object>) ((UISelectItems) comp).getValue());
			}
		}

		Object item = items.get(Integer.valueOf(value));

		if (item instanceof UISelectItem) {
			return ((UISelectItem) item).getValue();
		}

		return item;
	}

	public String getAsString(FacesContext facesContext, UIComponent uicomp,Object entity) {
		if (clientId == null || "".equals(clientId)	|| !clientId.equals(uicomp.getClientId())) {
			index = 0;
			clientId = uicomp.getClientId();
		}

		return entity == null ? "-1" : String.valueOf(index++);
	}
}