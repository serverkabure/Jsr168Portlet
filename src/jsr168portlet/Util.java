package jsr168portlet;

import java.io.File;
import java.util.Map;

public class Util {
	public static void main(String[] args) {
		// System.out.println(new File(".").getAbsolutePath());
		main0(null);
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
