package br.com.docesbyvic.controllers;

import br.com.docesbyvic.models.CompleteSell;
import br.com.docesbyvic.services.CompleteSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/complete-sell")
public class CompleteSellController {

    private final CompleteSellService completeSellService;

    // INJEÇÃO VIA CONSTRUTOR
    public CompleteSellController(CompleteSellService completeSellService) {
        this.completeSellService = completeSellService;
    }

    @GetMapping
    public List<CompleteSell> getAll() {
        return completeSellService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CompleteSell> getById(@PathVariable Long id) {
        return completeSellService.findById(id);
    }

    @PostMapping
    public CompleteSell create(@RequestBody CompleteSell completeSell) {
        return completeSellService.save(completeSell);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        completeSellService.delete(id);
    }
}
