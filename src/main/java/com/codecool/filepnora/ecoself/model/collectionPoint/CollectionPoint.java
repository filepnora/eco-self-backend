package com.codecool.filepnora.ecoself.model.collectionPoint;

import com.codecool.filepnora.ecoself.model.Address;
import com.codecool.filepnora.ecoself.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CollectionPoint {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private CollectedItemType itemType;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties({"collectionPoint"})
    private Address address;

    private String description;

    private String photoPath;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Status status;
}
