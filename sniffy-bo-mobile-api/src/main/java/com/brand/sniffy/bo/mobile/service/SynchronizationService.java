package com.brand.sniffy.bo.mobile.service;

import com.brand.sniffy.bo.mobile.domain.SynchronizationRequest;
import com.brand.sniffy.bo.mobile.domain.SynchronizationResult;


public interface SynchronizationService {
	
	SynchronizationResult performSynchronization(SynchronizationRequest request);
}
