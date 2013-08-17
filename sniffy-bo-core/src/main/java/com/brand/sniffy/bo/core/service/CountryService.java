package com.brand.sniffy.bo.core.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Country;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Country.class })
public interface CountryService {
	
	public void saveCountry(Country country);
	
	public Country updCountry(Country country);
}