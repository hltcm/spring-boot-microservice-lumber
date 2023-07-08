package com.tomruk.treetypeservice.repository;

import com.tomruk.treetypeservice.model.TreeType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeTypeRepository extends MongoRepository<TreeType, Long> {

}
