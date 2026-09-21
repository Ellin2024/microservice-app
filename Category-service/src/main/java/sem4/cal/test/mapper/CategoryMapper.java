package sem4.cal.test.mapper;


import sem4.cal.test.dto.CategoryRequest;
import sem4.cal.test.dto.CategoryResponse;
import sem4.cal.test.model.Categories;


public class CategoryMapper 
{
	//Request -> Entity
	public static Categories toEntity(CategoryRequest categoryRequest) {
		return Categories.builder()
				.categoryName(categoryRequest.getCategoryName())
				.categoryDescription(categoryRequest.getCategoryDescription())
				.build();
		
	}
	
	//Entity -> Response
	public static CategoryResponse toResponse(Categories categories) {
		return CategoryResponse.builder()
				.id(categories.getId())
				.categoryName(categories.getCategoryName())
				.categoryDescription(categories.getCategoryDescription())
				.build();
	}
}
