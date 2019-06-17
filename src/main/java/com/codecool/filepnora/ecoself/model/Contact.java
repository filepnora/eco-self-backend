package com.codecool.filepnora.ecoself.model;

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
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String phoneNumber;

    @OneToOne(mappedBy = "contact")
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties("contact")
    private Shop shop;
}
