package io.hungry.controllers;

import io.hungry.models.FoodRequest;
import io.hungry.models.FoodResponse;
import io.hungry.repository.FoodResponseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class FoodRequestController {

    @Autowired
    private FoodResponseRepository foodResponseRepository;

    private static final Logger logger = LoggerFactory.getLogger(FoodRequestController.class);

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public ResponseEntity<FoodResponse> requestDataPost(@RequestBody FoodRequest foodRequest){
        logger.info(foodRequest.toString());
        FoodResponse foodResponse = new FoodResponse("User requested " + foodRequest.getName() + " in:" + foodRequest.getZip());
        foodResponseRepository.save(foodResponse);
        return new ResponseEntity<>(foodResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public ResponseEntity<Iterable<FoodResponse>> requestDataGet(){
        Iterable<FoodResponse> reponses = foodResponseRepository.findAll();
        return new ResponseEntity<>(reponses, HttpStatus.OK);
    }

    @RequestMapping(value ="/request/{id}", method = RequestMethod.GET)
    public ResponseEntity<FoodResponse> requestGetItemById(@PathVariable("id") Long id){
        FoodResponse foodResponse = foodResponseRepository.findOne(id);
        return new ResponseEntity<>(foodResponse, HttpStatus.OK);
    }

    @RequestMapping(value="/findbyzip", method = RequestMethod.GET)
    public ResponseEntity<FoodResponse>  findWithZipcode(){
        FoodResponse foodResponse = foodResponseRepository.findByZipcode("19801");
        return new ResponseEntity<>(foodResponse, HttpStatus.OK);
    }
}
