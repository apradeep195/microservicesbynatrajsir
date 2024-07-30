package com.ndms.dto;

import lombok.Data;


public interface ItDepatmentDuesDetailsDTO {

Long getID();
int getERPLOGINSTATUS();
String getERPLOGIN();
int getERPLOGINACTION();
int getMAILALLOTED();
int getMAILREMOVED();
String getMAILTYPE();
int getAUTOMAILALLOTED();
int getAUTOMAILREMOVED();
int getPRINTERALLOTED();
int getPRINTEREMOVED();
String getREMARK();
}
