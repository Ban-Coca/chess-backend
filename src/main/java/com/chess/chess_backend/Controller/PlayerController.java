package com.chess.chess_backend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chess.chess_backend.Entity.Player;
import com.chess.chess_backend.Service.PlayerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@RestController
@RequestMapping("/player")
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;
    @GetMapping("/getplayer")
    public List<Player> getPlayers() {
        return playerService.getPlayer();
    }

    @PostMapping("/addplayer")
    public Player postPlayer( @RequestBody Player player) {
        // System.out.println("Authorization header: " + authorization); // Debug log
        // if (!isValidAuthorization(authorization)) {
        //     throw new Exception("Invalid authorization token");
        // }
        return playerService.addPlayer(player);
    }
    // private boolean isValidAuthorization(String authorization) {
    //     // Implement your logic to validate the authorization token
    //     // For example, compare it with a predefined token or validate it against Supabase
    //     return "my-supabase-key".equals(authorization);
    // }
}
