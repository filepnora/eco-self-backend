package com.codecool.filepnora.ecoself.repository;

import com.codecool.filepnora.ecoself.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("select s from Shop s")
    List<Shop> getAllShops();

    Shop getById(Long id);

    @Query("select s from Shop s where s.status = com.codecool.filepnora.ecoself.model.Status.ACCEPTED")
    List<Shop> getShopsByStatusAccepted();

    @Query("select s from Shop s where s.status = com.codecool.filepnora.ecoself.model.Status.PENDING")
    List<Shop> getShopsForAdmin();
}
