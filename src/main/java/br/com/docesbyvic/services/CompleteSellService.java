package br.com.docesbyvic.services;

import br.com.docesbyvic.models.CompleteSell;
import br.com.docesbyvic.repository.CompleteSellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompleteSellService {

    @Autowired
    private CompleteSellRepository completeSellRepository;

    public List<CompleteSell> findAll() {
        return completeSellRepository.findAll();
    }

    public Optional<CompleteSell> findById(Long id) {
        return completeSellRepository.findById(id);
    }

    public CompleteSell save(CompleteSell completeSell) {
        return completeSellRepository.save(completeSell);
    }

    public void delete(Long id) {
        completeSellRepository.deleteById(id);
    }
}
