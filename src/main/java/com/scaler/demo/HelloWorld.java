package com.scaler.demo;

import com.scaler.demo.model.Player;
import com.scaler.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorld {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/populate")
    public String populate(){
        Player p = new Player.Builder()
                .alias("Andrzej M Kiwi")
                .picURL("http://google.com")
                .psychFaceURL("http://google.com")
                .email("crajkumar72@gmail.com")
                .saltedHashedPassword("jgfbs")
                .build();
        playerRepository.save(p);
        return "populated";
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    @GetMapping("")
    public String hello(){
        return "Hello! Welcome to Psych Game!!!!!!!!!!!!";
    }
}
