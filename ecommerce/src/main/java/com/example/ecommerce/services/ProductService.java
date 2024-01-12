package com.example.ecommerce.services;

import com.example.ecommerce.models.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return repository.findById(id);
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProductById(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Could not delete product of id - " + id);
        }
    }

    public Product updateProductById(int id, Product updatedProduct) {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // Copy updated fields from updatedProduct to existingProduct, ignoring null & empty("") values
        copyObjectProperties(updatedProduct, existingProduct);

        return repository.save(existingProduct);
    }

    public static String[] getNullOrEmptyPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || (srcValue == "")) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    // then use Spring BeanUtils to copy and ignore null using our function
    public static void copyObjectProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullOrEmptyPropertyNames(src));
    }

}
