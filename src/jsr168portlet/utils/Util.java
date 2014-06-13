package jsr168portlet.utils;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;
import org.springframework.web.portlet.mvc.Controller;

public class Util {
	public static void main(String[] args) throws Exception {
		Resource resource = new ClassPathResource(
				"/jsr168portlet/utils/applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		//
		Controller controller = (Controller) factory
				.getBean("welcomeController");
		System.out.println(controller.handleRenderRequest(null, null)
				.getViewName());
	}

	public static void main1(String[] args) {
		Map<String, String> map = System.getenv();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.printf("%s, %s%n", entry.getKey(), entry.getValue());
		}
	}

	public static void main0(String[] args) {
		File folder = new File("./WebContent/WEB-INF/lib");
		File[] files = folder.listFiles();
		for (File file : files) {
			String filename = file.getName();
			if (filename.endsWith("-sources.jar")
					|| filename.endsWith("-javadoc.jar")) {
				file.delete();
			}
		}
	}
}
