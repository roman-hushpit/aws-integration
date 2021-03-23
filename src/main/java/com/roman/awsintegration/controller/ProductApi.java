package com.roman.awsintegration.controller;

import com.roman.awsintegration.rest.response.ProductResponse;
import com.roman.awsintegration.rest.request.ProductRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

public interface ProductApi {

    @RequestMapping(value = "/api/v1/product/{productId}",
            produces = {"application/json"},
    method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProduct(@PathVariable(name = "productId", required = true) Long productId);

    @RequestMapping(value = "/api/v1/product/{productId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId) throws Exception;

    @RequestMapping(value = "/api/v1/product",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request);

    @RequestMapping(value = "/api/v1/product/{productId}",
            produces = {"application/json"},
            method = RequestMethod.PATCH)
    ResponseEntity<ProductResponse> updateProduct(@PathVariable Long productId, @RequestBody ProductRequest request);

    @RequestMapping(value = "/api/v1/products",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<ProductResponse>> getAllProducts(@RequestParam(name = "minP", defaultValue = "0", required = false) BigDecimal minPrice,
                                                         @RequestParam(name = "maxP", defaultValue = Long.MAX_VALUE+"", required = false) BigDecimal maxPrice,
                                                         @RequestParam(name = "like", required = false, defaultValue = "") String like,
                                                         Pageable pageable);
}
