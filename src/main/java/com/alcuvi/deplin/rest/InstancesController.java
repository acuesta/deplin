package com.alcuvi.deplin.rest;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alcuvi.deplin.InstanceManager;
import com.alcuvi.deplin.rest.model.Instance;

@RestController
@RequestMapping("/instances")
public class InstancesController {
	
	@Inject
	InstanceManager instanceManager;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Instance>> getAll(){
        return new ResponseEntity<>((Collection<Instance>) instanceManager.getAll(), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Instance instance) {
        return new ResponseEntity<>(instanceManager.save(instance), HttpStatus.CREATED);
    }
	
}
