package br.com.docesbyvic.repository;

import br.com.docesbyvic.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Aqui tu pode criar métodos personalizados depois
}