package com.alcuvi.deplin.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alcuvi.deplin.db.model.InstanceEntity;

@Repository
public interface InstanceRepository extends MongoRepository<InstanceEntity, String> {


}
