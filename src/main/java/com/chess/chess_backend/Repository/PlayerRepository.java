package com.chess.chess_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chess.chess_backend.Entity.Player;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
    
}
