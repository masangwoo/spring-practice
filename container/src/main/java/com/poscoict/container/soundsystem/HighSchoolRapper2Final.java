package com.poscoict.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HighSchoolRapper2Final implements CompactDisc {
	@Autowired
	private CompactDisc cd;
	@Override
	public void play() {
		cd.play();
	}

}