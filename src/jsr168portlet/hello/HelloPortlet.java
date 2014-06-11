package jsr168portlet.hello;

import java.io.*;
import java.util.*;

import javax.portlet.*;

/**
 * JSP未使用のJSR168ポートレット
 * 
 */
public class HelloPortlet extends GenericPortlet {
	// private String viewPage, editPage, helpPage;
	String html;

	@Override
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		// viewPage = config.getInitParameter("viewPage");
		// editPage = config.getInitParameter("editPage");
		// helpPage = config.getInitParameter("helpPage");
		html = "Welcome";
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
		html = pref.getValue("html", "<p>いらっしゃい</p>");
		request.setAttribute("html", html);
		response.setContentType(request.getResponseContentType());
		PrintWriter writer = response.getWriter();
		StringBuffer sb = new StringBuffer();
		sb.append("<form>").append(html).append("</form>");
		writer.write(sb.toString());
		writer.close();
		// PortletRequestDispatcher dispatcher = getPortletContext()
		// .getRequestDispatcher(viewPage);
		// dispatcher.include(request, response);
	}

	@Override
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletPreferences pref = request.getPreferences();
		html = pref.getValue("html", "いらっしゃい");
		request.setAttribute("html", html);
		response.setContentType(request.getResponseContentType());
		PrintWriter writer = response.getWriter();
		StringBuffer sb = new StringBuffer();
		String actionUrl = response.createActionURL().toString();
		sb.append("<form action='" + actionUrl + "' method='post'>");
		sb.append("<table>");
		sb.append("<tr><td><input type='submit'></td>	</tr>");
		sb.append("<tr><td><textarea name='html' rows='10' cols='40'>")
				.append(html).append("</textarea></td><tr>");
		sb.append("<tr><td>").append(html).append("</td></tr>");
		sb.append("</table>");
		sb.append("</form>");
		writer.write(sb.toString());
		writer.close();
		// PortletRequestDispatcher dispatcher = getPortletContext()
		// .getRequestDispatcher(editPage);
		// dispatcher.include(request, response);
	}

	@Override
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.setContentType(request.getResponseContentType());
		PrintWriter writer = response.getWriter();
		StringBuffer sb = new StringBuffer();
		sb.append("<form>");
		sb.append("<p>help page</p>");
		sb.append("</form>");
		writer.write(sb.toString());
		writer.close();
		// PortletRequestDispatcher dispatcher = getPortletContext()
		// .getRequestDispatcher(helpPage);
		// dispatcher.include(request, response);
	}
}
