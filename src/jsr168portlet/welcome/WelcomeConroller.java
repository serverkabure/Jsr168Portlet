package jsr168portlet.welcome;

import java.util.*;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.Controller;

public class WelcomeConroller implements Controller {
	private String viewName;

	@Override
	public void handleActionRequest(ActionRequest request,
			ActionResponse response) throws Exception {
		String html = request.getParameter("html");
		PortletPreferences pref = request.getPreferences();
		pref.setValue("html", html);
		pref.store();
	}

	@Override
	public ModelAndView handleRenderRequest(RenderRequest request,
			RenderResponse response) throws Exception {
		PortletPreferences pref = request.getPreferences();
		String html = pref.getValue("html", "こんにちは");
		return new ModelAndView(viewName, "html", html);
		
		// Map<?, ?> map = request.getPreferences().getMap();
		// return new ModelAndView(viewName, "map", map);
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
