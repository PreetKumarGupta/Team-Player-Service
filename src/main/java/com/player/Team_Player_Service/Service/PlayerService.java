package com.player.Team_Player_Service.Service;

import com.player.Team_Player_Service.Entities.Player;
import com.player.Team_Player_Service.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void deleteById(int id) {
        playerRepository.deleteById(id);
    }

    public void deleteAll() {
        playerRepository.deleteAll();
    }

    public Optional<Player> findById(int id) {

        return playerRepository.findById(id);
    }

    public Player update(int id, Player player) {
        return
                playerRepository.findById(id).map(p -> {
            player.setName(player.getName());
            player.setAge(player.getAge());
            return playerRepository.save(player);
                } ).orElse(null);




    }
}
