package com.player.Team_Player_Service.Controller;


import com.player.Team_Player_Service.Entities.Player;
import com.player.Team_Player_Service.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/players")
public class PlayerController {


    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public Optional<Player> getById(@PathVariable int id){
        return playerService.findById(id);
    }


    @GetMapping
    public List<Player> getAllPlayer(){
         return playerService.findAll();
    }

    @PostMapping("/add")
    public Player addPlayer(@RequestBody Player player){
        return playerService.save(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable int id,@RequestBody Player player){
        return  playerService.update(id,player);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
          playerService.deleteById(id);
    }

    @DeleteMapping("/all")
    public void deleteAll(){
        playerService.deleteAll();
    }

}
