package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

import com.brand.sniffy.bo.core.model.Country;
import com.brand.sniffy.bo.core.model.Producer;
import com.brand.sniffy.bo.core.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private ProducerService producerService;
	
	@Override
	public void saveCountry(Country country) {
		country.setLastUpdate(new Date().getTime());
		countryRepository.save(country);
	}

	@Override
	public Country updCountry(Country country) {
		country.setLastUpdate(new Date().getTime());
		return countryRepository.save(country);
	}

	@Override
	public List<Country> findCountrysChangedAfter(Long lastSynchronization) {
		return countryRepository.findByLastUpdateGreaterThan(lastSynchronization);
	}

	@Override
	public void deleteCountry(Country country) {
		for(Producer producer: country.getProducers()){
			producer.setCountry(null);
			producerService.saveProducer(producer);
		}
		
		countryRepository.delete(country);
	}
}
