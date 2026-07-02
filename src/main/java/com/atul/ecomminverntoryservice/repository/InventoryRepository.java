package com.atul.ecomminverntoryservice.repository;

import com.atul.ecomminverntoryservice.model.InventoryModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryModel, String> {
}
