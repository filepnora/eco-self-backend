package com.codecool.filepnora.ecoself.model;

import com.codecool.filepnora.ecoself.model.collectionPoint.CollectionPoint;
import com.codecool.filepnora.ecoself.model.shop.Shop;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String country;
    private String city;
    private String address;
    private String zip;

    @OneToOne(mappedBy = "address")
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties("address")
    private Shop shop;

    @OneToOne(mappedBy = "address")
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties("address")
    private CollectionPoint collectionPoint;
}
