package com.alcuvi.deplin;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import com.alcuvi.deplin.db.model.InstanceEntity;
import com.alcuvi.deplin.db.repositories.InstanceRepository;
import com.alcuvi.deplin.rest.model.Instance;

@Named
public class InstanceManager {

	private final InstanceRepository instanceRepository;

	@Inject
	public InstanceManager(final InstanceRepository instanceRepository) {
		this.instanceRepository = instanceRepository;
	}

	public Collection<Instance> getAll() {

		final Collection<Instance> allInstances = new ArrayList<>();
		final Iterable<InstanceEntity> entities = instanceRepository.findAll();
		for (final InstanceEntity instanceEntity : entities) {
			final Instance instance = new Instance();
			instance.setName(instanceEntity.getName());
			instance.setDescription(instanceEntity.getDescription());
			instance.setUrl(instanceEntity.getUrl());
			allInstances.add(instance);
		}
		return allInstances;
	}

	public String save(final Instance instance) {
		final InstanceEntity instanceEntity = new InstanceEntity();
		instanceEntity.setName(instance.getName());
		instanceEntity.setDescription(instance.getDescription());
		instanceEntity.setUrl(instance.getUrl());
		instanceRepository.save(instanceEntity);
		return instanceEntity.toString();
	}

}
