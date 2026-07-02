package com.atul.ecomminverntoryservice.controller;

import com.atul.ecomminverntoryservice.model.InventoryModel;
import com.atul.ecomminverntoryservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryModel> checkInventory(@PathVariable String productId) throws Exception {
        InventoryModel inventory = inventoryService.findDetailsId(productId);

        if (inventory != null) {
            return ResponseEntity.ok(inventory); // 200 OK with body
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }


    @PostMapping("/addInventory")
    public String addInventory(@RequestBody InventoryModel inventoryModel){
        return inventoryService.addInventory(inventoryModel);
    }

    @PutMapping("/update")
    public String updatedQuantity(@RequestBody  InventoryModel inventoryModel){
        return inventoryService.updateInventory(inventoryModel);
    }


}
