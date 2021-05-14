package me.kormanik.couponservice.repo;

import me.kormanik.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

    Coupon findByCode(String code);

}
