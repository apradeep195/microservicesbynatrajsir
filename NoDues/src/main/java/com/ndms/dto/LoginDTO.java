package com.ndms.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginDTO {

	@NonNull
	private Long userId;
	@NonNull
	private String password;

	private String path;
	
}
