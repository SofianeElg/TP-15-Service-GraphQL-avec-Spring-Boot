package com.example.banque_service.repositories;

import com.example.banque_service.entities.Compte;
import com.example.banque_service.entities.Transaction;
import com.example.banque_service.entities.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Used by compteTransactions query
    List<Transaction> findByCompte(Compte compte);

    // Used by transactionStats query to get total sum of a specific type (DEPOT or RETRAIT) across all accounts
    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.type = :type")
    double sumByType(@Param("type") TypeTransaction type); // <-- ADD THIS METHOD

    // Used by soldeCompte query to get the sum of a specific type for one account
    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.compte = :compte AND t.type = :type")
    double sumByCompteAndType(@Param("compte") Compte compte, @Param("type") TypeTransaction type); // <-- ADD THIS METHOD
}