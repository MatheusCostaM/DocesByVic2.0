package br.com.docesbyvic.services;

import br.com.docesbyvic.models.Client;
import br.com.docesbyvic.models.Product;
import br.com.docesbyvic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Classe responsável pela regra de negócio (serviço)
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Salvar ou atualizar um produto
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Listar todos os produtos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Buscar produto por id
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new RuntimeException("Client not found with id: " + id);
    }

    // Deletar produto por id
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
