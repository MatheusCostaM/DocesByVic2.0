package br.com.docesbyvic.controllers;

import br.com.docesbyvic.models.Promotion;
import br.com.docesbyvic.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Classe que expõe as rotas da API referentes à Promotion
@RestController
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    // Criar nova promoção
    @PostMapping
    public Promotion createPromotion(@RequestBody Promotion promotion) {
        return promotionService.savePromotion(promotion);
    }

    // Listar todas promoções
    @GetMapping
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    // Buscar promoção por id
    @GetMapping("/{id}")
    public Optional<Promotion> getPromotionById(@PathVariable Long id) {
        return promotionService.getPromotionById(id);
    }

    // Deletar promoção por id
    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotion(id);
    }
}
