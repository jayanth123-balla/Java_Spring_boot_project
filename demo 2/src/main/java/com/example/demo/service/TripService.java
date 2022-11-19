package com.example.demo.service;
import com.example.demo.entities.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import com.example.demo.service.CabService;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.Math;


@Service
public class TripService {
    private final Map<Integer, Trip> tripRepo= new HashMap<>();
    private final AtomicInteger counter=new AtomicInteger();
    @Autowired
    private CabService cabService;
    public TripService(CabService cabService){
        this.cabService=cabService;
    }

    public Map getAllTrip(){
        return tripRepo;
    }
    public Trip getTrip(Integer id){
        for(Map.Entry<Integer, Trip> entry : tripRepo.entrySet()) {
            Trip trip =  entry.getValue();
            Integer key = entry.getKey();
            if(key==id) {
                System.out.println(key);
                System.out.println(trip);
            }
        }
        return tripRepo.get(id);
    }
    public Trip addTrip(Integer source, Integer destination, String rider_name){
        String driver_name= cabService.getCab(1).getDriver_name();
        String cab_number=cabService.getCab(1).getNumber();
        Trip trip=new Trip(source, destination, (Math.abs(destination-source)*20), rider_name, driver_name, cab_number);
        Trip someUser= tripRepo.put(counter.incrementAndGet(), trip);
        System.out.println(trip);
        return trip;
    }

}
