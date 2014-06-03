package jsr168portlet.welcome;

import java.io.IOException;

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

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher(viewPage);
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
