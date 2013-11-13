package com.brand.sniffy.bo.core.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Country;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Country.class })
public interface CountryService {
	
	public void saveCountry(Country country);
	
	public Country updCountry(Country country);

	public List<Country> findCountrysChangedAfter(Long lastSynchronization);
	
	public void deleteCountry(Country country);
}
