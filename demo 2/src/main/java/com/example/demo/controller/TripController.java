package com.example.demo.controller;
import com.example.demo.entities.Trip;
import com.example.demo.entities.Cab;
import com.example.demo.service.TripService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;



@SpringBootApplication
@RestController
public class TripController {
    @Autowired
    private TripService tripService;
    public TripController(TripService tripService){
        this.tripService=tripService;
    }
    @GetMapping("/trips")
    public Map getAllTrip(){
        return tripService.getAllTrip();
    }

    @GetMapping("/trip/{id}")
    public Trip getTrip(@PathVariable Integer id){
        return (Trip) tripService.getTrip(id);
    }

    @PostMapping("/trip/add")
    public String[] addTrip(@RequestParam(value = "source", defaultValue = "1") Integer source,
                                 @RequestParam(value="destination") Integer destination,
//                                 @RequestParam(value="price") Float price,
                                 @RequestParam(value="rider_name") String rider_name
//                                 @RequestParam(value="driver_name") String driver_name,
//                                 @RequestParam(value="cab_number") String cab_number
                            ) {
        Trip newTrip=tripService.addTrip(source,destination,rider_name);
        return newTrip.getValue();
    }
}
