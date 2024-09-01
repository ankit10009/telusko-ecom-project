package com.example.ecom_proj.service;

import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProduct(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repository.save(product);
    }
    public Product updateProduct(int id,Product product,MultipartFile imageFile) throws IOException {

            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());
            return repository.save(product);

    }

    public void deleteProductById(int productId) {
        repository.deleteById(productId);
    }

    public List<Product> searchProducts(String keyword) {
        return repository.searchProducts(keyword);
    }
}
