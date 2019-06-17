package com.codecool.filepnora.ecoself.controller;

import com.codecool.filepnora.ecoself.model.collectionPoint.CollectionPoint;
import com.codecool.filepnora.ecoself.repository.CollectionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectionPointController {

    @Autowired
    private CollectionPointRepository collectionPointRepository;

    @GetMapping("/collection-points")
    private List<CollectionPoint> getAllCollectionPoints(){
        return collectionPointRepository.getAllCPs();
    }

    @GetMapping("collection-points/{id}")
    private CollectionPoint getCPById(@PathVariable Long id){
        return collectionPointRepository.getById(id);
    }

}
