package com.sensedia.test.app;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public abstract class SimpleIntegrationTest {
	@Before
	public final void setup(){
		this.doSetup();
	}
	
	@After
	public final void destroy(){
		this.doDestroy();
	}
	
	protected void doSetup(){
		
	}
	
	protected void doDestroy(){
		
	}
}