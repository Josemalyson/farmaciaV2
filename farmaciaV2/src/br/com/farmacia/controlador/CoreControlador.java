package br.com.farmacia.controlador;

import java.io.Serializable;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.util.FacesUtil;

public abstract class CoreControlador implements Serializable {
	private static final long serialVersionUID = -1458543199050434843L;
	protected static final String CURRENT_VIEW = null;
	protected static final String REDIRECT_URL = "faces-redirect=true";
	protected static final String INCLUDE_VIEW_PARAMETERS = "includeViewParams=true";

	public String sendRedirect(String redirect) {
		return redirect + "?" + REDIRECT_URL;
	}

	public String sendRedirectWithParameter(String redirect) {
		return redirect + "?" + REDIRECT_URL + "&"
				+ "includeViewParams=true";
	}

	public ServletContext getServletContext() {
		return FacesUtil.getServletContext();
	}

	public void setManagedBeanInSession(String beanName, Object managedBean) {
		FacesUtil.setManagedBeanInSession(beanName, managedBean);
	}

	public Object getRequestParameter(Object name) {
		return FacesUtil.getRequestParameter(name);
	}

	public void setRequestParameter(String key, Object value) {
		FacesUtil.setRequestParameter(key, value);
	}

	public Object setSessionAttribute(String key, Object value) {
		return FacesUtil.setSessionAttribute(key, value);
	}

	public Object getSessionAttribute(String key) {
		return FacesUtil.getSessionAttribute(key);
	}

	public HttpServletRequest getServletRequest() {
		return FacesUtil.getServletRequest();
	}

	public HttpServletResponse getServletResponse() {
		return FacesUtil.getServletResponse();
	}

	public String getRealPath(String pasta) {
		return FacesUtil.getRealPath(pasta);
	}

	public void adicionarAtributoFlash(String nome, Object objeto) {
		FacesUtil.adicionarAtributoFlash(nome, objeto);
	}

	public Object obterAtributoFlash(String nome) {
		return FacesUtil.obterAtributoFlash(nome);
	}

	public FacesContext getContexto() {
		return FacesUtil.obterContexto();
	}

	public String getContextPath() {
		return FacesUtil.getServletContext().getContextPath();
	}

	public void adicionarMensagem(String texto) {
		FacesUtil.adicionarMensagem(texto);
	}

	public void adicionarAviso(String texto) {
		FacesUtil.adicionarAviso(texto);
	}

	public void adicionarErro(String texto) {
		FacesUtil.adicionarErro(texto);
	}

	public void manterMensagensNoFlash() {
		FacesUtil.manterMensagensNoFlash();
	}

	public NavigationHandler obterNavigationHandler() {
		return FacesUtil.obterNavigationHandler();
	}

	public FacesContext obterContexto() {
		return FacesUtil.obterContexto();
	}
}