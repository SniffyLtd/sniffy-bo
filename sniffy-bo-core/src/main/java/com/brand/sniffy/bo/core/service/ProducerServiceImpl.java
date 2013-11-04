package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

import com.brand.sniffy.bo.core.model.Producer;
import com.brand.sniffy.bo.core.repository.ProducerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerRepository producerRepository;
	
	@Override
	public void saveProducer(Producer producer) {
		producer.setLastUpdate(new Date().getTime());
		producerRepository.save(producer);
	}

	@Override
	public Producer updateProducer(Producer producer) {
		producer.setLastUpdate(new Date().getTime());
		return producerRepository.save(producer);
	}

	@Override
	public List<Producer> findAll() {
		return producerRepository.findAll();
	}
}
