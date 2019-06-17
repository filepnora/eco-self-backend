package com.codecool.filepnora.ecoself;

import com.codecool.filepnora.ecoself.model.Address;
import com.codecool.filepnora.ecoself.model.Contact;
import com.codecool.filepnora.ecoself.model.Status;
import com.codecool.filepnora.ecoself.model.collectionPoint.CollectedItemType;
import com.codecool.filepnora.ecoself.model.shop.Shop;
import com.codecool.filepnora.ecoself.model.shop.ShopType;
import com.codecool.filepnora.ecoself.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class EcoSelfApplication {

    @Autowired
    ShopRepository shopRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcoSelfApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(){
        return args -> {

            Contact zoldBoltContact = Contact.builder().email("info@zoldbolt.hu").phoneNumber("+36 20 462 6901").build();

            Address zoldboltAddress = Address.builder().country("Hungary").city("Budapest").address("Kiss János altábornagy u. 35").zip("1126").build();

            Shop zoldbolt = Shop.builder().name("Zöldbolt").shopType(ShopType.PACKAGE_FREE_SHOP).contact(zoldBoltContact).address(zoldboltAddress).status(Status.ACCEPTED).build();

            zoldBoltContact.setShop(zoldbolt);
            zoldboltAddress.setShop(zoldbolt);

            shopRepository.save(zoldbolt);
        };
    }

}
