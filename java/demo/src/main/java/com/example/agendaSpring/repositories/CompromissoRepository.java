package com.example.agendaSpring.repositories;

import com.example.agendaSpring.entidades.Compromisso;
import com.example.agendaSpring.entidades.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {

    List<Compromisso> findAllByContatos(Contato contato);

    @Query(value = "select * from tb_compromisso where data between :dataInicio AND :dataFim", nativeQuery = true)
    List<Compromisso> findAllByEntreDatas(Date dataInicio, Date dataFim);



}
