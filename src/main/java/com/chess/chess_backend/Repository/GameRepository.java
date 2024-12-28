package com.chess.chess_backend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chess.chess_backend.Entity.Game;

public interface GameRepository extends JpaRepository<Game, UUID> {
    
}
