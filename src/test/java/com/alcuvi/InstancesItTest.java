package com.alcuvi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class InstancesItTest {

	final static Logger logger = Logger.getLogger(InstancesItTest.class);

	final static String SERVER = "http://localhost:8080";
	final static String GET_INSTANCES_URL = SERVER + "/instances";

	@Test
	public void getAllInstances() throws IOException, Exception {
		final GetExecution getAllInstancesExecution = new GetExecution();
		final HttpStatus status = getAllInstancesExecution.executeGet(GET_INSTANCES_URL);
		Assert.assertEquals(HttpStatus.OK, status);
	}

	class GetExecution {

		private HttpStatus executeGet(final String restURL) throws IOException, Exception {
			HttpURLConnection conn = null;
			try {
				final URL url = new URL(restURL);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setDoOutput(true);
				conn.setDoInput(true);

			} finally {
				if (conn != null) {
					conn.disconnect();
				}
			}
			return HttpStatus.valueOf(conn.getResponseCode());
		}
	}
}
