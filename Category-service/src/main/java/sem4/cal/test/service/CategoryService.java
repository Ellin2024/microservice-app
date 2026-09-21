package sem4.cal.test.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sem4.cal.test.dto.CategoryRequest;
import sem4.cal.test.dto.CategoryResponse;
import sem4.cal.test.mapper.CategoryMapper;
import sem4.cal.test.model.Categories;
import sem4.cal.test.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;

	CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<CategoryResponse> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList());
	}

	public CategoryResponse create(CategoryRequest request) {
		// TODO Auto-generated method stub
		Categories categories = categoryRepository.save(CategoryMapper.toEntity(request));
		return CategoryMapper.toResponse(categories);
	}

	public CategoryResponse update(Long id, CategoryRequest request) {
		// TODO Auto-generated method stub
		
		// 1. Find the existing task or throw an error
		Categories existingCategories = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found with id : "+id));
		
		//2. Update fields (Check for nulls if you want partial updates)
		if(request.getCategoryName() != null ) existingCategories.setCategoryName(request.getCategoryName());
		if(request.getCategoryDescription() != null ) existingCategories.setCategoryDescription(request.getCategoryDescription());
		
		// 3. Save and return
		Categories updateCategories = categoryRepository.save(existingCategories);
		return CategoryMapper.toResponse(updateCategories);
	}

	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		if(categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			return true;
		}
		else {
			
			return false;
		}
			
	}

	public CategoryResponse findById(Long id) {
		// TODO Auto-generated method stub
		
		// 1. Fetch from Repository
	    Categories category = categoryRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

	    // 2. Map Entity to Response DTO
	    return CategoryMapper.toResponse(category);
		
	}


	
	
}
