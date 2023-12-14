package com.example.agendaSpring.repositories;

import com.example.agendaSpring.entidades.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Long> {
    boolean existsByEmail(String email);
    boolean existsByFone(String fone);
    boolean existsByNome(String nome);
}
