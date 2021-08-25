package com.popa.microservices.core.product.businesslayer;

import com.popa.api.core.product.Product;
import com.popa.microservices.core.product.datalayer.ProductEntity;
import com.popa.microservices.core.product.datalayer.ProductRepository;
import com.popa.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Test
    public void testGetProductByIdValid(){
        //arrange
        ProductEntity entity = new ProductEntity(1, "n", 1);
        when(productRepository.findByProductId(1)).thenReturn(Optional.of(entity));

        //act
        Product returnedProduct = productService.getProductById(1);

        //assert
        assertThat(returnedProduct.getProductId()).isEqualTo(1);
    }

    @DisplayName("GetByProductId Product Found")
    @Test
    public void testGetProductByIdNotFound(){
        assertThrows(NotFoundException.class, () -> productService.getProductById(1));
    }
}