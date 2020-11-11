package com.oscars.restws.services;

import com.oscars.restws.model.Product;
import com.oscars.restws.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Response createProduct(Product product) {
        return Response.ok(productRepository.save(product)).build();
    }

    @Override
    public Response updateProduct(Product product) {
        return Response.ok(productRepository.save(product)).build();
    }

    @Override
    public Response deleteProduct(int id) {
        final Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }

}
