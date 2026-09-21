package sem4.cal.test.controller;

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

import sem4.cal.test.dto.CategoryRequest;
import sem4.cal.test.dto.CategoryResponse;
import sem4.cal.test.model.Categories;
import sem4.cal.test.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;


	//Get All Category
	@GetMapping()
	private ResponseEntity<List<CategoryResponse>> getAllCategory() {
		return ResponseEntity.ok(categoryService.findAll());
		
	}
	
	//Create A Category
	@PostMapping("/create")
	private ResponseEntity<?> createCategory(@RequestBody CategoryRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoryService.create(request));
	}
	
	//Update A Category
	@PutMapping("/update/{id}")
	private ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request) {
		return ResponseEntity.ok(categoryService.update(id, request));
	}
	
	//Delete A Category
	@DeleteMapping("/delete/{id}")
	private boolean deleteCategory(@PathVariable Long id) {
		System.out.println("Deleted id : "+id);
		return categoryService.deleteById(id);
	}
	
	//Find By CategoryId
	@GetMapping("/{id}")
	private ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id) {
		
		System.out.println("Request id : "+ id);
		return ResponseEntity.ok(categoryService.findById(id));
	}
	
}
