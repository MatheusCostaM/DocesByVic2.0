package br.com.docesbyvic.repository;

import br.com.docesbyvic.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface de conexão com o banco de dados (CRUD automático do JPA)
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
