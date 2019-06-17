package com.codecool.filepnora.ecoself.model.shop;

import com.codecool.filepnora.ecoself.model.Address;
import com.codecool.filepnora.ecoself.model.Contact;
import com.codecool.filepnora.ecoself.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Shop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ShopType shopType;

    private String photoPath;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties({"shop"})
    private Contact contact;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties({"shop"})
    private Address address;

    @NonNull
    private Status status;

}
