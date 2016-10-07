package io.hungry.repository;

import io.hungry.models.FoodResponse;
import org.springframework.data.repository.CrudRepository;


public interface FoodResponseRepository extends CrudRepository<FoodResponse, Long>{
    FoodResponse findByZipcode(String zipcode);
}
