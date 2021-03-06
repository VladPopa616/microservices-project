package com.popa.microservices.core.product.presentationlayer.controllers;


import com.popa.api.core.product.Product;
import com.popa.api.core.product.ProductServiceAPI;
import com.popa.microservices.core.product.businesslayer.ProductService;
import com.popa.utils.exceptions.InvalidInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRESTController implements ProductServiceAPI {

    private static final Logger LOG = LoggerFactory.getLogger(ProductRESTController.class);

    private final ProductService productService;

    @Autowired
    public ProductRESTController(ProductService productService)
    {
        this.productService = productService;
    }

    @Override
    public Product getProduct(int productId) {
        LOG.debug("/product MS returns the found product for productId: " + productId);

        if(productId < 1)throw new InvalidInputException("Invalid productId: " + productId);

        // if(productId == 13)throw new NotFoundException("No product found for productId: " + productId);

        Product product = productService.getProductById(productId);

        return product;
    }

    @Override
    public Product createProduct(Product model) {

        Product product = productService.createProduct(model);

        LOG.debug("REST createProduct: entity created for productId: {}", product.getProductId());

        return product;
    }

    @Override
    public void deleteProduct(int productId) {

        LOG.debug("REST deleteProduct: tries to delete entity for productId: {}", productId);
        productService.deleteProduct(productId);

    }
}
