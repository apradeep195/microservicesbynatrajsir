package com.ndms.enums;



public enum ResignReasonEnums {

	RETIREMENT(10),
	RESIGNATION(20),
	TERMINATION(30),
	DEATH(40),
	TRANSFER(50),
	PROMOTION(60),
	TERMINATION_OF_TRAINING(35),
	COMPLETION_OF_TRAINING(42),
	COMPLETION_OF_CONTRACT(45);

	Integer value;

	private ResignReasonEnums(Integer value) {
		
		this.value=value;
		}

	public int getValue() {
		return this.value;
	}

	public static ResignReasonEnums getresignReasonEnums(int value) {	
		  
		for(ResignReasonEnums resign : 	ResignReasonEnums.values())
	    {
			 
	         if(resign.getValue()!=value)
	    	        continue;
	    	 return resign;
	    	 
	    }
	    return null;
	    
	}


	
}
