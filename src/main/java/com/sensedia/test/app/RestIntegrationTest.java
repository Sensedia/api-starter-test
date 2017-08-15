package com.sensedia.test.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public abstract class RestIntegrationTest extends IntegrationTest {
	@LocalServerPort
	private int port;
	
	@Value("${server.contextPath}")
	private String contextPath;

	@Override
	protected void doSetup() {
		RestAssured.port = this.port;
	}
	
	public int getPort() {
		return port;
	}
	
	protected String contextPath(){
		return this.contextPath;
	}
}