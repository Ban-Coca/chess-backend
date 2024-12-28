package com.chess.chess_backend.Entity;
import java.util.UUID;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID gameId;
    private UUID player1;
    private UUID player2;
    
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    @OneToMany(mappedBy = "game")
    private List<Move> moves;

    public Game(UUID gameId, Room room, Player winner, UUID player1, UUID player2){
        this.gameId = gameId;
        this.room = room;
        this.winner = winner;
        this.player1 = player1;
        this.player2 = player2;
    }
}
