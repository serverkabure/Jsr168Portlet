package jsr168portlet.welcome;

import java.io.*;
import java.util.*;

import javax.portlet.*;

public class WelcomePortlet extends GenericPortlet {
	private String viewPage, editPage, helpPage;

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		viewPage = config.getInitParameter("viewPage");
		editPage = config.getInitParameter("editPage");
		helpPage = config.getInitParameter("helpPage");
	}

	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException {
		String html = request.getParameter("html");
		try {
			PortletPreferences pref = request.getPreferences();
			pref.setValue("html", html);
			pref.store();
		} catch (Exception e) {
			throw new PortletException(e.getMessage());
		}
		// return the user back to the view mode and normal state
		// response.setPortletMode(PortletMode.VIEW);
		// response.setWindowState(WindowState.NORMAL);
	}

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletPreferences pref = request.getPreferences();
		String html = pref.getValue("html", "いらっしゃい");
		//
		// response.setContentType(request.getResponseContentType());
		// PrintWriter writer = response.getWriter();
		// writer.write("<form><p> " + html +
		// "</p><p>日本語テスト。①Ⅰⅰ、～㎜㈱。</p></form>");
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher(viewPage);
		request.setAttribute("html", html);
		dispatcher.include(request, response);
	}

	@Override
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher(editPage);
		dispatcher.include(request, response);
	}

	@Override
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher(helpPage);
		dispatcher.include(request, response);
	}
}
