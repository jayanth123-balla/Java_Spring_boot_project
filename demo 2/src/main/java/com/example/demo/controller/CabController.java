package com.example.demo.controller;
import com.example.demo.entities.Cab;
import com.example.demo.service.CabService;
import com.example.demo.service.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@SpringBootApplication
@RestController
public class CabController {
    @Autowired
    private CabService cabService;
    public CabController(CabService cabService){
        this.cabService=cabService;
    }

    @GetMapping("/cabs")
    public Map getAllCab(){
        return cabService.getAllCab();
    }

    @GetMapping("/cab/{id}")
    public Cab getCab(@PathVariable Integer id){
        return (Cab) cabService.getCab(id);
    }
    @PostMapping("/cab/register")
    public String[] registerCab(@RequestParam(value = "driver_name", defaultValue = "user") String driver_name,
                                 @RequestParam(value="type") String type,
                                 @RequestParam(value="number") String number) {
        Cab regTrip=cabService.registerCab(driver_name, type,number);
        return regTrip.getValue();
    }
}
