package sem4.pro.test.mapper;

import sem4.pro.test.dto.CategoriesDto;
import sem4.pro.test.model.Products;
import sem4.pro.test.request.ProductRequest;
import sem4.pro.test.response.ProductResponse;

public class ProductMapper {

	//Request -> Entity
	public static Products toEntity(ProductRequest productRequest) {
		return Products.builder()
				.productName(productRequest.getProductName())
				.productDescription(productRequest.getProductDescription())
				.productCode(productRequest.getProductCode())
				.categoryId(productRequest.getCategoryId())
				.build();
		
	}
	
	//Entity -> Response
	public static ProductResponse toResponse(Products products, CategoriesDto categoriesDto) {
		return ProductResponse.builder()
				.id(products.getId())
				.productName(products.getProductName())
				.productDescription(products.getProductDescription())
				.productCode(products.getProductCode())
				.categoriesDto(categoriesDto)
				.build();
	}
}
