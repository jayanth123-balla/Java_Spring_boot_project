package com.example.demo.service;
import com.example.demo.entities.Cab;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class CabService {
    private final Map<Integer, Cab> cabRepo= new HashMap<>();
    private final AtomicInteger counter=new AtomicInteger();

    public Map getAllCab(){
        return cabRepo;
    }
    public Cab getCab(Integer id){
        return cabRepo.get(id);
    }
    public String getSomeCab(Integer id){
        Cab somecab=cabRepo.get(id);
        return somecab.getDriver_name();
    }
    public Cab registerCab(String driver_name, String type, String number){
        Cab cab=new Cab(driver_name, type, number);
        Cab somecab= cabRepo.put(counter.incrementAndGet(), cab);
        System.out.println(cab);
        return cab;
    }
}
