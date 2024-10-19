package org.example.test_spring.Dao;

import org.example.test_spring.Bean.Commande;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDAO extends JpaRepository<Commande, Long> {
    Commande findByRef(String ref);
    void deleteByRef(String ref);
    @NotNull
    List<Commande> findAll() ;
    List<Commande> findByRefAndTotalGreaterThan(String ref, Double total);
}
