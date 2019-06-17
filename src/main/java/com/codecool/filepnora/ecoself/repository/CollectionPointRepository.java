package com.codecool.filepnora.ecoself.repository;

import com.codecool.filepnora.ecoself.model.collectionPoint.CollectionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectionPointRepository extends JpaRepository<CollectionPoint, Long> {

    @Query("select c from CollectionPoint c")
    List<CollectionPoint> getAllCPs();

    CollectionPoint getById(Long id);
}
