package me.kormanik.couponservice;

import me.kormanik.couponservice.model.Coupon;
import me.kormanik.couponservice.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CouponController {

    @Autowired
    private CouponRepo couponRepo;


    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponRepo.save(coupon);
    }

    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons() {
        return couponRepo.findAll();
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable final String code) {
        return couponRepo.findByCode(code);
    }
}
