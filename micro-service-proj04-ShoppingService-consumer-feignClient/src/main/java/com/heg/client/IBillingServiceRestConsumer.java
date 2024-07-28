package com.heg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("billing-service")
public interface IBillingServiceRestConsumer {

	@GetMapping("/info")
	public String fetchBillDetaills();
}
