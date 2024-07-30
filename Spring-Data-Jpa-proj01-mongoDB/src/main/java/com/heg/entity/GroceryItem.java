package com.heg.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("groceryitems")
@Data
public class GroceryItem {

	 @Id
     private String id;

     private String name;
     private int quantity;
     private String category;
}
