package com.internetsam.stat_search;

public class AlertHandler {
	
	Main main = new Main();
	
	public String warning(String input) {
		
		input = main.infoPane.getText()+"Warning: "+input+"\n";
		return input;		
	}
	
	public String info(String input) {
		
		input = main.infoPane.getText()+"Info: "+input+"\n";
		return input;
	}
	
	public String error(String input) {
		
		input = main.infoPane.getText()+"Error: "+input+"\n";
		return input;
	}
}
