package com.heg.entity.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.heg.entity.GroceryItem;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {

}
