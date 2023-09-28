package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.iProductService;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private iProductService productService;

    @GetMapping
    public String testController() {
        return "Product controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name) {
        return "Product controller works, " + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerMethod() {
        return "Product controller method works!";
    }

    @PostMapping(value = "/get")
    public ProductDTO queryProduct(@RequestBody ProductDTO product) {
        return this.productService.queryProduct(product);
    }

    @GetMapping(value = "/getAll")
    public List<ProductDTO> queryAllProduct() {
        return this.productService.queryAllProducts();
    }

    @PostMapping(value = "/add")
    public int addProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.insertProduct(productDTO);
    }

    @PutMapping(value = "/put")
    public int putProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.updateProduct(productDTO);
    }

    @DeleteMapping (value = "/delete")
    public int deleteProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.deleteProduct(productDTO);
    }
}