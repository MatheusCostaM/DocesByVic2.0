package br.com.docesbyvic.repository;

import br.com.docesbyvic.models.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Responsável por acessar o banco de dados da entidade Sell
@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {
}
