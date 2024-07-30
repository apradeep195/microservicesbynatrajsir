package com.ndms.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIResponse<T> {

	private boolean status;
	private String message;
	private T data;

}
