package sem4.pro.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sem4.pro.test.request.ProductRequest;
import sem4.pro.test.response.ProductResponse;
import sem4.pro.test.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//Get All Product
	@GetMapping()
	private ResponseEntity<List<ProductResponse>> getAllProduct() {
		
		return ResponseEntity.ok(productService.findAll());
	}
	
	//Create A Product
	@PostMapping("/create")
	private ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(productService.create(request));
	}
	
	//Update A Product 
	@GetMapping("/update")
	private ResponseEntity<?> updateProduct() {
		return ResponseEntity.ok(productService.getAllCategory());
	}
	
}
