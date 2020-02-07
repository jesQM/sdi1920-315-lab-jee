package com.uniovi.sdi.complementario3;

public class Comment {
	private String username;
	private String content;
	
	public Comment(String user, String content) {
		this.username = user;
		this.content = content;
	}
	
	public String getUsername() {
		return username;
	}
	public String getContent() {
		return content;
	}
	
	
}
