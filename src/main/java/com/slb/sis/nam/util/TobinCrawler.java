package com.slb.sis.nam.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;

/**
 * @author	Biswajeet.Basumatary
 * @date	Friday, 27 October 2017 10:43:11
 * @project	vdl-review
 *
 *
 */
public class TobinCrawler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		// read the credential 	
		TobinCredential cred = new TobinCredential();
		
		System.out.println(cred.getUrl());
		System.out.println(cred.getPassword());
		
		
		// ftp client ...
		
		FTPClient ftp = new FTPClient();
		
		FTPClientConfig config = new FTPClientConfig();
		
		
		
		
	}

}
