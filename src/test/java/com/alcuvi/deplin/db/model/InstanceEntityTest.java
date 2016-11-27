package com.alcuvi.deplin.db.model;

import org.junit.Assert;
import org.junit.Test;

public class InstanceEntityTest {

	private static final String INSTANCE_ENTITY_NAME = "deplin_Dev";
	private static final String INSTANCE_ENTITY_DESC = "deplin instance for development";
	private static final String INSTANCE_ENTITY_URL = "www.deplin_dev.com";
	private static final Object INSTANCE_ENTITY_STRING = "Instance[name=" + INSTANCE_ENTITY_NAME + ", desc='" + INSTANCE_ENTITY_DESC
			+ "', url='" + INSTANCE_ENTITY_URL + "']";

	@Test
	public void instanceWithDefaultConstructor() {
		final InstanceEntity instance = new InstanceEntity();
		instance.setName(INSTANCE_ENTITY_NAME);
		instance.setDescription(INSTANCE_ENTITY_DESC);
		instance.setUrl(INSTANCE_ENTITY_URL);

		Assert.assertEquals(INSTANCE_ENTITY_NAME, instance.getName());
		Assert.assertEquals(INSTANCE_ENTITY_DESC, instance.getDescription());
		Assert.assertEquals(INSTANCE_ENTITY_URL, instance.getUrl());
		Assert.assertEquals(INSTANCE_ENTITY_STRING, instance.toString());
	}

}
