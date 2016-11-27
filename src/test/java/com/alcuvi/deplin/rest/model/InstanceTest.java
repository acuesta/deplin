package com.alcuvi.deplin.rest.model;

import org.junit.Assert;
import org.junit.Test;

public class InstanceTest {

	private static final String INSTANCE_URL = "www.deplin_dev.com";
	private static final String INSTANCE_DESC = "deplin instance for development";
	private static final String INSTANCE_NAME = "deplin_Dev";

	@Test
	public void instanceWithDefaultConstructor() {
		final Instance instance = new Instance();
		instance.setName(INSTANCE_NAME);
		instance.setDescription(INSTANCE_DESC);
		instance.setUrl(INSTANCE_URL);

		Assert.assertEquals(INSTANCE_NAME, instance.getName());
		Assert.assertEquals(INSTANCE_DESC, instance.getDescription());
		Assert.assertEquals(INSTANCE_URL, instance.getUrl());
	}

}
