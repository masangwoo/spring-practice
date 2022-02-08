package com.poscoict.container.videosystem;

public class ironMan implements DigitalVideoDisc {
	private String studio = "MARVEL";
	private String title = "ironMan";
	
	@Override
	public void play() {
		System.out.println("Playing Movie " + studio + "'s " + title);
	}

}
