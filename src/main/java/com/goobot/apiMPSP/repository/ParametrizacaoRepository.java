package com.goobot.apiMPSP.repository;

import com.goobot.apiMPSP.model.Parametrizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ParametrizacaoRepository extends JpaRepository<Parametrizacao, Long> {

    @Query("SELECT p from Parametrizacao p WHERE p.chave = ?1")
    Parametrizacao findByKey(String chave);
}
