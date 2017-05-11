package br.eti.thiagogarciaalves.arquillian.cube;

import com.jayway.restassured.RestAssured;
import org.arquillian.cube.HostIp;
import org.arquillian.cube.HostPort;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class PingPongTest {

	@HostIp
	private String ip;

	@HostPort(containerName = "ping-pong", value = 8080)
	private int port;

	@Test
	public void shouldDoGet() {
		assertEquals(200, RestAssured.get("http://" + ip + ":" + port).getStatusCode());
	}

	@Test
	public void shouldDoPost() {
		assertEquals(200, RestAssured.post("http://" + ip + ":" + port).getStatusCode());
	}

}
