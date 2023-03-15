package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Product;
import edu.wctc.wholesale.exception.ResourceNotFoundException;
import edu.wctc.wholesale.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int product_id) throws ResourceNotFoundException {
        Optional<Product> optional = productRepository.findById(product_id);
        if(optional.isPresent())
            return optional.get();
        else
            throw new ResourceNotFoundException("Product", "name", Integer.toString(product_id));
    }

    public Product getProduct(String productName) throws ResourceNotFoundException {

        Optional<Product> optional = productRepository.findByName(productName);
        if(optional.isPresent())
            return optional.get();
        else
            throw new ResourceNotFoundException("Product", "name", productName);    }
}
