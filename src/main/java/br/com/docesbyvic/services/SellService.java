package br.com.docesbyvic.services;

import br.com.docesbyvic.models.Sell;
import br.com.docesbyvic.repository.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Contém as regras de negócio da entidade Sell
@Service
public class SellService {

    @Autowired
    private SellRepository sellRepository;

    // Lista todas as vendas
    public List<Sell> getAllSells() {
        return sellRepository.findAll();
    }

    // Busca uma venda específica pelo ID
    public Optional<Sell> getSellById(Long id) {
        return sellRepository.findById(id);
    }

    // Cria uma nova venda
    public Sell createSell(Sell sell) {
        return sellRepository.save(sell);
    }

    // Atualiza uma venda existente
    public Sell updateSell(Long id, Sell updatedSell) {
        Sell sell = sellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sell not found with id " + id));

        sell.setProduct(updatedSell.getProduct());
        sell.setQuantity(updatedSell.getQuantity());
        sell.setValue(updatedSell.getValue());

        return sellRepository.save(sell);
    }

    // Remove uma venda
    public void deleteSell(Long id) {
        sellRepository.deleteById(id);
    }
}
