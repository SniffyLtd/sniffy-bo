package com.brand.sniffy.bo.core.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Producer;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Producer.class })
public interface ProducerService {
	
	public void saveProducer(Producer producer);
	
	public Producer updateProducer(Producer producer);

	public List<Producer> findAll();
}
