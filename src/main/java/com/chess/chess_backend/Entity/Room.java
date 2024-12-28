package com.chess.chess_backend.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roomId;
    private String roomCode;
    private boolean isActive;
    private LocalDateTime created_at;

    @OneToOne(mappedBy = "room")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Player host;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Player guest;
    
    public Room(UUID roomId, String roomCode, Player host, Player guest, boolean isActive, LocalDateTime created_at){
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.host = host;
        this.guest = guest;
        this.isActive = isActive;
        this.created_at = created_at;
    }
}
