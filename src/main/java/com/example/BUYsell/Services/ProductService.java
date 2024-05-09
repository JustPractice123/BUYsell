package com.example.BUYsell.Services;

import com.example.BUYsell.Models.Product;
import com.example.BUYsell.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(String title){
        if (title!=null) return productRepository.findAllByTitle(title);
        return productRepository.findAll();
    }
    public void saveProdusct(Product product, MultipartFile file)
            throws IOException {
        if (file.getSize()!=0){
//            image1=toImageEntity(file1);
//            image1.setPreviewImage(true);
//            product.addImageToProduct(image1);
        }
        log.info("Saving new Product. Title:{}; Author:{}", product.getTitle(), product.getAuthor());
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    public Product getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow();
        return product;
    }
}
