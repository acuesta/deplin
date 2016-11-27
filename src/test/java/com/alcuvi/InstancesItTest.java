package com.alcuvi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DeplinApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class InstancesItTest {

	final static Logger logger = Logger.getLogger(InstancesItTest.class);

	final static String SERVER = "http://localhost:8080";
	final static String GET_INSTANCES_URL = SERVER + "/instances";

	@Test
	public void getAllInstances() throws IOException, Exception {
		final HttpStatus status = executeGet(GET_INSTANCES_URL);
		Assert.assertEquals(HttpStatus.OK, status);
	}

	public HttpStatus executeGet(final String restURL) throws IOException, Exception {
		HttpURLConnection conn = null;
		HttpStatus status = null;
		try {
			final URL url = new URL(restURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			status = HttpStatus.valueOf(conn.getResponseCode());
			
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return status;
	}
}
