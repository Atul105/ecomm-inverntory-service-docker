package com.atul.ecomminverntoryservice.service;

import com.atul.ecomminverntoryservice.exception.ResourceNotFoundException;
import com.atul.ecomminverntoryservice.model.InventoryModel;
import com.atul.ecomminverntoryservice.repository.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public String addInventory(InventoryModel inventoryModel){
        inventoryRepository.save(inventoryModel);
        return "Inventory successfullly added.";
    }

    public String updateInventory(InventoryModel inventoryModel) {
        String id = inventoryModel.getProductId();
        Optional<InventoryModel> existingOpt = inventoryRepository.findById(id);

        if (existingOpt.isPresent()) {
            InventoryModel existing = existingOpt.get();

            // Update only the fields you want to change
            existing.setQuantity(inventoryModel.getQuantity());
            existing.setProductName(inventoryModel.getProductName());

            inventoryRepository.save(existing); // persist changes
            return "Inventory successfully updated.";
        } else {
            return "Inventory not found.";
        }
    }


    public InventoryModel findDetailsId(String id) throws Exception {
        Thread.sleep(5000);
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + id));
    }

}

