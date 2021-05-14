package me.kormanik.productservice.controller;

import me.kormanik.productservice.dto.Coupon;
import me.kormanik.productservice.model.Product;
import me.kormanik.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${couponservice.url}")
    private String couponServiceUrl;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        Coupon coupon = restTemplate.getForObject(getUrl(product), Coupon.class);
        if (coupon != null) {
            product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        }
        return productRepo.save(product);
    }

    private String getUrl(Product product) {
        return couponServiceUrl + product.getCouponCode();
    }


}
