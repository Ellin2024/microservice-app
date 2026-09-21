package sem4.pro.test.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sem4.pro.test.client.CategoriesClient;
import sem4.pro.test.dto.CategoriesDto;
import sem4.pro.test.mapper.ProductMapper;
import sem4.pro.test.model.Products;
import sem4.pro.test.repository.ProductRepository;
import sem4.pro.test.request.ProductRequest;
import sem4.pro.test.response.ProductResponse;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoriesClient categoriesClient;

	public ProductResponse create(ProductRequest request) {
		// TODO Auto-generated method stub
		Products products = ProductMapper.toEntity(request);
		
		Products savedProduct = productRepository.save(products);
		
		CategoriesDto categories = categoriesClient.getCategoryById(savedProduct.getCategoryId());
		return ProductMapper.toResponse(savedProduct , categories);
	}

	public List<ProductResponse> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll()
				.stream()
                .map(product -> ProductMapper.toResponse(product, categoriesClient.getCategoryById(product.getCategoryId())))
                .collect(Collectors.toList());
	}

	public List<ProductResponse> getAllCategory() {
		// TODO Auto-generated method stub
		return productRepository.findAll()
				.stream()
				.map(product -> ProductMapper.toResponse(product, categoriesClient.getAllCategory()))
				.collect(Collectors.toList());
	}
	
	
	
}
