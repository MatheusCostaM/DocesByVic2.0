package br.com.docesbyvic.controllers;

import br.com.docesbyvic.models.Sell;
import br.com.docesbyvic.services.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Responsável pelas rotas e comunicação externa da entidade Sell
@RestController
@RequestMapping("/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    // Retorna todas as vendas
    @GetMapping
    public List<Sell> getAllSells() {
        return sellService.getAllSells();
    }

    // Busca uma venda por id
    @GetMapping("/{id}")
    public Optional<Sell> getSellById(@PathVariable Long id) {
        return sellService.getSellById(id);
    }

    // Cria uma nova venda
    @PostMapping
    public Sell createSell(@RequestBody Sell sell) {
        return sellService.createSell(sell);
    }

    // Atualiza uma venda
    @PutMapping("/{id}")
    public Sell updateSell(@PathVariable Long id, @RequestBody Sell sell) {
        return sellService.updateSell(id, sell);
    }

    // Deleta uma venda
    @DeleteMapping("/{id}")
    public void deleteSell(@PathVariable Long id) {
        sellService.deleteSell(id);
    }
}
