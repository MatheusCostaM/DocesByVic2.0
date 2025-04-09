package br.com.docesbyvic.repository;

import br.com.docesbyvic.models.CompleteSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteSellRepository extends JpaRepository<CompleteSell, Long> {
}
