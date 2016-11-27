package com.alcuvi.deplin.db.model;

import org.springframework.data.annotation.Id;


public class InstanceEntity {
	
	@Id
	private String name;
	
	private String description;
	
	private String url;

	public InstanceEntity() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    @Override
    public String toString() {
        return String.format("Instance[name=%s, desc='%s', url='%s']", name, description, url);
    }
	
}
