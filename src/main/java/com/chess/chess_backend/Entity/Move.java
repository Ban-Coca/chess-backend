package com.chess.chess_backend.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "move")
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID moveId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private int moveNumber;
    private String fromPosition;
    private String toPosition;
    private LocalDateTime createdAt;

    public Move(UUID moveId, Game gameId, Player playerId, int moveNumber, String fromPosition, String toPosition, LocalDateTime createdAt){
        this.moveId = moveId;
        this.game = gameId;
        this.player = playerId;
        this.moveNumber = moveNumber;
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
        this.createdAt = createdAt;
    }
}