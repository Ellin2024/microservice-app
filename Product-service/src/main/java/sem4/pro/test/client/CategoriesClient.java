package sem4.pro.test.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sem4.pro.test.dto.CategoriesDto;

@FeignClient( name = "category-service", url= "${category.base.url:http://category-service:8081}") //""
public interface CategoriesClient {

	//CategoryFindById
	@GetMapping("/api/categories/{id}")
	CategoriesDto getCategoryById(@PathVariable Long id);
	
	@GetMapping("/api/categories/")
	CategoriesDto getAllCategory();
}
