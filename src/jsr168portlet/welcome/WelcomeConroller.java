package jsr168portlet.welcome;

import java.util.*;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.Controller;

public class WelcomeConroller implements Controller {
	private String viewName;

	@Override
	public void handleActionRequest(ActionRequest request,
			ActionResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public ModelAndView handleRenderRequest(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, String> map = new HashMap<>();
		return new ModelAndView(viewName, "map", map);
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
