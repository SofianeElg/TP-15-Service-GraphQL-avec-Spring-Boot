package com.example.banque_service.dao;

import com.example.banque_service.entities.TypeTransaction;
import lombok.Data;
import java.time.LocalDateTime; // Change imported class

@Data
public class TransactionRequest {
    private Long compteId;
    private double montant;
    private LocalDateTime date; // <-- CHANGED TYPE
    private TypeTransaction type;
}