package com.scaler.demo.controller;

import com.scaler.demo.model.*;
import com.scaler.demo.repositories.GameRepositoty;
import com.scaler.demo.repositories.PlayerRepository;
import com.scaler.demo.repositories.QuestionsRepository;
import com.scaler.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dev-test")
public class DevTestController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepositoty gameRepositoty;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/populate")
    public String populate(){
        for(Player player: playerRepository.findAll()) {
            player.getGame().clear();
            playerRepository.save(player);
        }
        gameRepositoty.deleteAll();
        playerRepository.deleteAll();
        questionsRepository.deleteAll();
        Player p = new Player.Builder()
                .alias("Andrzej M Kiwi")
                .picURL("http://google.com")
                .psychFaceURL("http://google.com")
                .email("crajkumar72@gmail.com")
                .saltedHashedPassword("jgfbs")
                .build();
        playerRepository.save(p);
        Player p2 = new Player.Builder()
                .alias("Andrzej M Kiwi")
                .picURL("http://google.com")
                .psychFaceURL("http://google.com")
                .email("crajkumar73@gmail.com")
                .saltedHashedPassword("jgfbs")
                .build();
        playerRepository.save(p2);
        Game g = new Game();
        g.setGameMode(GameMode.IS_THIS_A_FACT);
        g.setGameStatus(GameStatus.PLAYERS_JOINING);
        g.setHasEllen(true);
        g.setLeader(p);
        g.getPlayers().add(p);
        g.getPlayers().add(p2);
        gameRepositoty.save(g);
        questionsRepository.save(new Question("what is name?","your name..",GameMode.IS_THIS_A_FACT));
        questionsRepository.save(new Question("what is name?","your name..",GameMode.IS_THIS_A_FACT));
        return "populated";
    }

    @GetMapping("")
    public String hello(){
        return "Hello! Welcome to Psych Game!!!!!!!!!!!!";
    }
    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable long id){
        return playerRepository.findById(id).orElseThrow();
    }
    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionsRepository.findAll();
    }
    @GetMapping("/questions/{id}")
    public Question getQuestionById(@PathVariable long id){
        return questionsRepository.findById(id).orElseThrow();
    }
    @GetMapping("/games")
    public List<Game> getAllGames(){
        return gameRepositoty.findAll();
    }
    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable long id){
        return gameRepositoty.findById(id).orElseThrow();
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id){
        return userRepository.findById(id).orElseThrow();
    }
}
