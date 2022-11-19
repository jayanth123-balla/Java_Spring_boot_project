package com.example.demo.service;
import com.example.demo.entities.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class UserService {
    private final Map<Integer, User> userRepo= new HashMap<>();
    private final AtomicInteger counter=new AtomicInteger();

    public Map getAllUser(){
        return userRepo;
    }
    public User getUser(Integer id){
        return userRepo.get(id);
    }
    public User registerUser(String name, String phone, String email){
//        User user=new User(name, phone, email);
        User user=new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        User someUser= userRepo.put(counter.incrementAndGet(), user);
        System.out.println(user);
        return user;
    }

}

//    UserService(){ //constructor
//        User user = new User("John", "89364293987", "john@gmail.com");
//        userRepo.put(1,user);
//    }


//        for(Map.Entry<Integer, User> entry : userRepo.entrySet()) {
//            User user =  entry.getValue();
//            Integer key = entry.getKey();
//            //do something with the key and value
//            if(key==id) {
//                System.out.println(key);
//                System.out.println(user);
//            }
//        }