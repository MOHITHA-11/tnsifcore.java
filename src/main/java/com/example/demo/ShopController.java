package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<shop> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<shop> getShopById(@PathVariable Long id) {
        Optional<shop> shop = shopService.getShopById(id);
        return shop.map(value -> ResponseEntity.ok().body(value))
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<shop> createShop(@RequestBody shop shop) {
        shop createdShop = shopService.createShop(shop);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<shop> updateShop(@PathVariable Long id, @RequestBody shop shop) {
        shop updatedShop = shopService.updateShop(id, shop);
        return updatedShop != null ? ResponseEntity.ok().body(updatedShop) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
