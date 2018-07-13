package com.jpa.exercise.amazonecommerce.controller;

import com.jpa.exercise.amazonecommerce.domain.Product;
import com.jpa.exercise.amazonecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Product getById(@PathVariable("id") Long id){
        return productService.getById(id);
    }

    @PostMapping
    public @ResponseBody
    Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody Product update(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
