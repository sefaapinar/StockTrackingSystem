package com.StokTakip.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StokTakip.Model.Item;
import com.StokTakip.Service.ItemService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> get(@PathVariable int id){
		try {
			Item product = itemService.getItemById(id);
			return new ResponseEntity<Item>(product,HttpStatus.OK);
			
		}
		catch(Exception exception){
			
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/list")
	public List<Item> productList(){
		
		return itemService.getAllItems();
	}
	
	
	@PostMapping("/")
	public void AddItem(@RequestBody Item product) {
		itemService.createItem(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@RequestBody Item product){
		try {
			itemService.updateItem(product);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception exception){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable int id) {
		itemService.deleteItem(id);
	}
	
	@GetMapping("/count")
	public long count() {
		return itemService.getItemCount();
	}
	
			
	    
	
	
}













