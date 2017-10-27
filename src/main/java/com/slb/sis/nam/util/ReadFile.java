package com.slb.sis.nam.util;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Biswajeet.Basumatary
 * @date Friday, 27 October 2017 09:25:02
 * @project vdl-review
 *
 *
 */
public class ReadFile {

	static List<String[]> masterList = new ArrayList<String[]>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String link = "src/main/resources/mms.txt";

		try (Stream<String> stream = Files.lines(Paths.get(link))) {

			masterList = stream.map(s -> splitText(s)).collect(Collectors.toList());


		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String[] blah : masterList) {

			try {
				getFile(blah);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private static String[] splitText(String s) {

		String[] list = s.split(",");

		// System.out.println(list[0] + " : " + list[1] + " : " + list[2]);

		return list;
	}

	private static void getFile(String[] l) throws Exception {

		
		URL downloadLink = new URL(l[2]);
		
		BufferedInputStream bis = new BufferedInputStream(downloadLink.openStream());
		
		String[] fileObj = (l[2]).split("/"); 
		
		String file = "src/main/resources/"+ fileObj[fileObj.length - 1];
		
		FileOutputStream fis = new FileOutputStream(file);
		
		System.out.println("Downloading from " + file);

		byte[] buffer = new byte[1024];
		int bytesRead = 0;

		while ((bytesRead = bis.read(buffer)) > 0) {
			fis.write(buffer, 0, bytesRead);
			buffer = new byte[102400];
		}
		
		fis.close();

	}
}
