package jsr168portlet;

import java.io.File;

public class Util {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File folder = new File(
				"C:/eclipse-jee-juno-SR2-win32/workspace/Jsr168Portlet/WebContent/WEB-INF/lib");
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.getName().endsWith("-sources.jar")) {
				file.delete();
			}
		}
	}
}
