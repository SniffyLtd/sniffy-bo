package com.brand.sniffy.bo.core.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Producer;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Producer.class })
public interface ProducerService {
	
	public void saveProducer(Producer producer);
	
	public Producer updateProducer(Producer producer);
}
