package com.slb.sis.nam.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Biswajeet.Basumatary
 * @date Friday, 27 October 2017 10:27:57
 * @project vdl-review
 *
 *
 */
public class TobinCredential {

	private String url;
	private String username;
	private String password;

	public TobinCredential() {
		readCredential();
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	private void readCredential() {

		String file = "src/main/resources/tobin.credential";

		List<String[]> credential = null;

		try (Stream<String> stream = Files.lines(Paths.get(file))) {

			credential = stream.map(s -> splitText(s)).collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String[] s : credential) {
			this.url = s[0];
			this.username = s[1];
			this.password = s[2];
		}

	}

	private static String[] splitText(String s) {

		String[] list = s.split(",");

		return list;
	}

}
