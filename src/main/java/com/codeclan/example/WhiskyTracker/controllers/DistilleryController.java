package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping
    public ResponseEntity<List<Distillery>> findDistilleriesFilterByRegion(@RequestParam(name = "region",required = false)String region){
        if(region !=null){
            return new ResponseEntity(distilleryRepository.findDistilleryByRegion(region),HttpStatus.OK);
        }
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);
    }
}


//    @GetMapping
//    public ResponseEntity findRaidsFilterByLocation(@RequestParam(name = "location", required = false)String location){
//        if(location !=null){
//            return new ResponseEntity(raidRepository.findRaidByLocation(location), HttpStatus.OK);
//        }
//        return new ResponseEntity(raidRepository.findAll(), HttpStatus.OK);
//    }