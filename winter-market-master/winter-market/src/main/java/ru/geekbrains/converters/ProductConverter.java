package ru.geekbrains.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.dtos.ProductDto;
import ru.geekbrains.entities.Product;

@Component
public class ProductConverter {
    public ProductDto entityToDto(Product p) {
        ProductDto productDto = new ProductDto();
        productDto.setId(p.getId());
        productDto.setTitle(p.getTitle());
        productDto.setPrice(p.getPrice());
        return productDto;
    }
}
