package br.com.docesbyvic.repository;

import br.com.docesbyvic.models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface que faz conexão com o banco de dados para Promotion
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
