package com.entelgy.Comments.Common;

import org.springframework.stereotype.Component;

@Component
public class Constants {
	
	public static final String URL_VALIDATION = "https://jsonplaceholder.typicode.com/comments";
	
	private Constants() {
		
	}

	public static void load() {
		// Do nothing
	}
}
