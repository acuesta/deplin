package com.alcuvi.deplin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.alcuvi.deplin.db.model.InstanceEntity;
import com.alcuvi.deplin.db.repositories.InstanceRepository;
import com.alcuvi.deplin.rest.model.Instance;

@RunWith(MockitoJUnitRunner.class)
public class InstanceManagerTest {

	private InstanceManager manager = null;

	@Mock
	private InstanceRepository instanceRepository;

	@Before
	public void setUp() {
		manager = new InstanceManager(instanceRepository);
	}
	
	@Test
	public void testGetAllInstancesWhenNoInstanceSaved() {
		Mockito.when(instanceRepository.findAll()).thenReturn(Collections.emptyList());
		final Collection<Instance> allInstances = manager.getAll();
		Assert.assertNotNull(allInstances);
		Assert.assertEquals(0, allInstances.size());

	}

	@Test
	public void testGetAllInstancesWhenManyInstanceSaved() {
		Mockito.when(instanceRepository.findAll()).thenReturn(buildInstances());
		final Collection<Instance> allInstances = manager.getAll();
		Assert.assertNotNull(allInstances);
		Assert.assertEquals(2, allInstances.size());

	}

	private List<InstanceEntity> buildInstances() {
		final List<InstanceEntity> instances = new ArrayList<>();
		instances.add(new InstanceEntity());
		instances.add(new InstanceEntity());
		return instances;
	}

}
