package com.sensedia.test.app;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@ActiveProfiles("test")
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public abstract class IntegrationTestApplication {
	@LocalServerPort
	private int port;
	
	@Before
	public final void setup(){
		RestAssured.port = this.port;
		this.doSetup();
	}
	
	@After
	public final void destroy(){
		this.doDestroy();
	}
	
	public int getPort() {
		return port;
	}
	
	protected void doSetup(){
		
	}
	
	protected void doDestroy(){
		
	}
}