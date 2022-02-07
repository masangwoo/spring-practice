package com.poscoict.container.soundsystem;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poscoict.container.config.soundsystem.CDPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CDPlayerConfig.class})
public class CDPlayerJavaConfigTest {
	@Autowired
	private CDPlayer cdPlayer;

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	@Test
	public void testCDPlayerNot() {
		
			cdPlayer.play();
			
			assertEquals(systemOutRule.getLog().replace("\r\n",""),"Playing 붕붕 by 김하온");
		
	} 
}
