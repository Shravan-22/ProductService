package com.example.ProductService.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    //when Endpoint - http://hello pi is called this should return
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    //for calling a dynamic variable
    @GetMapping("/hello/{name}")
    public String helloWithName(@PathVariable("name") String name){
        return "Hello " + name;
    }

    //for calling multiple variables
    @GetMapping("/show/{showId}/seat/{seatId}")
    public String BookMyShow(@PathVariable("showId") String showId, @PathVariable("seatId") int seatId){
        return "Hello " + showId + " " + seatId;
    }

}
