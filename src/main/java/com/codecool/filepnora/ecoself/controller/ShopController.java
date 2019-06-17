package com.codecool.filepnora.ecoself.controller;

import com.codecool.filepnora.ecoself.model.Address;
import com.codecool.filepnora.ecoself.model.Contact;
import com.codecool.filepnora.ecoself.model.Status;
import com.codecool.filepnora.ecoself.model.shop.Shop;
import com.codecool.filepnora.ecoself.model.shop.ShopType;
import com.codecool.filepnora.ecoself.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("/shops")
    private List<Shop> getAllShops() {
        return shopRepository.getAllShops();
    }

    @GetMapping("/shops/{id}")
    private Shop getShopById(@PathVariable Long id) {
        return shopRepository.getById(id);
    }

    @GetMapping("/shops/accepted")
    private List<Shop> getAcceptedShops() {
        return shopRepository.getShopsByStatusAccepted();
    }

    @GetMapping("/shops/admin/pending")
    private List<Shop> getPendingShops() {
        return shopRepository.getShopsForAdmin();
    }

    @PostMapping("/shops")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveNewShopByUserSumbit(
            @RequestParam("shopName") String name,
            @RequestParam("shopType") ShopType shopType,
            @RequestParam("shopAddressCountry") String country,
            @RequestParam("shopAddressCity") String city,
            @RequestParam("shopAddressAddress") String address,
            @RequestParam("shopAddressZip") String zip,
            @RequestParam(name = "shopEmail", required = false) String email,
            @RequestParam(name = "shopPhoneNumber", required = false) String phoneNumber
    ) {
        Address newShopAddressByUser =
                Address.builder().country(country).city(city).address(address).zip(zip).build();

        Contact newShopContactByUser =
                Contact.builder().email(email).phoneNumber(phoneNumber).build();

        Shop newShopByUser =
                Shop.builder().name(name)
                        .shopType(shopType)
                        .address(newShopAddressByUser)
                        .contact(newShopContactByUser)
                        .status(Status.PENDING).build();

        shopRepository.save(newShopByUser);

    }
/*
    @PostMapping("/shops/admin")
    private void saveNewShopByAdmin() {

    }

    @PostMapping("/shops/{id}/edit")
    private void editShopDetails(
            @PathVariable("id") Long id,
            @RequestParam("shopName") String name,
            @RequestParam("shopType") ShopType shopType,
            @RequestParam("shopAddressCountry") String country,
            @RequestParam("shopAddressCity") String city,
            @RequestParam("shopAddressAddress") String address,
            @RequestParam("shopAddressZip") String zip,
            @RequestParam(name = "shopEmail", required = false) String email,
            @RequestParam(name = "shopPhoneNumber", required = false) String phoneNumber
    ) {
        shopRepository.getById(id);


    }
*/
}
