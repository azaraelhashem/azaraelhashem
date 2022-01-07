package com.example.accessingdatamysql;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FeedBackRepository extends CrudRepository<FeedBack, Integer> {
    
    @Query(value = "select * from feed_back  where fb_type like ?1%", nativeQuery = true)
    List<FeedBack> filtered(String argString);
}
