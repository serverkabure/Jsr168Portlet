package jsr168portlet;

import java.io.File;

public class Util {

	public static void main(String[] args) {
		File folder = new File(
				"C:/eclipse-jee-juno-SR2-win32/workspace/Jsr168Portlet/WebContent/WEB-INF/lib");
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
