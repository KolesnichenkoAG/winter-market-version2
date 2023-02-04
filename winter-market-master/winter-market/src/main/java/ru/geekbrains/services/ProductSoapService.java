package ru.geekbrains.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.entities.Product;
import ru.geekbrains.repositories.ProductRepository;
import ru.geekbrains.soap.products.ProductSoap;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductSoapService {
    private final ProductRepository productRepository;

    public static final Function<Product, ProductSoap> functionEntityToSoap = pe -> {
        ProductSoap p = new ProductSoap();
        p.setId(pe.getId());
        p.setTitle(pe.getTitle());
        p.setPrice(pe.getPrice());
        return p;
    };

    public List<ProductSoap> getAllProducts() {
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public ProductSoap getByTitle(String title) {
        return productRepository.findByName(title).map(functionEntityToSoap).get();
    }
}
