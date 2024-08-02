package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	 @Autowired
	    private ShopRepository shopRepository;

	    public List<shop> getAllShops() {
	        return shopRepository.findAll();
	    }

	    public Optional<shop> getShopById(Long id) {
	        return shopRepository.findById(id);
	    }

	    public shop createShop(shop shop) {
	        return shopRepository.save(shop);
	    }

	    public shop updateShop(Long id, shop updatedShop) {
	        if (shopRepository.existsById(id)) {
	            updatedShop.setShopId(id);
	            return shopRepository.save(updatedShop);
	        }
	        return null; // Or throw exception if needed
	    }

	    public void deleteShop(Long id) {
	        shopRepository.deleteById(id);}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
