package com.chess.chess_backend.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chess.chess_backend.Entity.Player;
import com.chess.chess_backend.Repository.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getPlayer() {
        return playerRepository.findAll();
    }

    @SuppressWarnings("finally")
    public Player putPlayer(UUID playerId, Player newPlayerDetails) {
        Player player = new Player();
        try{
            player = playerRepository.findById(playerId).get();
            player.setUsername(newPlayerDetails.getUsername());
        }catch(Exception e){
            throw new RuntimeException("Player not found");
        } finally {
            return playerRepository.save(player);
        }
    }
}
