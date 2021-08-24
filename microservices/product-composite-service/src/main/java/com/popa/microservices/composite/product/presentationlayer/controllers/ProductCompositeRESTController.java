package com.popa.microservices.composite.product.presentationlayer.controllers;


import com.popa.api.composite.product.*;
import com.popa.microservices.composite.product.businesslayer.ProductCompositeService;
import com.popa.microservices.composite.product.businesslayer.ProductCompositeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCompositeRESTController implements ProductCompositeServiceAPI {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeServiceImpl.class);

    private final ProductCompositeService productCompositeService;

    public ProductCompositeRESTController(ProductCompositeService productCompositeService) {
        this.productCompositeService = productCompositeService;
    }

    @Override
    public ProductAggregate getProduct(int productId) {

        LOG.debug("ProductComposite received getProductComposite request.");

        ProductAggregate productAggregate = productCompositeService.getProduct(productId);

        return productAggregate;
    }

    @Override
    public void createCompositeProduct(ProductAggregate model) {

        LOG.debug("ProductComposite received dreateProductComposite request.");

        productCompositeService.createProduct(model);
    }

    @Override
    public void deleteCompositeProduct(int productId) {
        LOG.debug("ProductComposite received deleteProductComposite request.");
        productCompositeService.deleteProduct(productId);
    }

}
