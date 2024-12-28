package com.chess.chess_backend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chess.chess_backend.Entity.Move;

public interface MoveRepository extends JpaRepository<Move, UUID> {
    
}
