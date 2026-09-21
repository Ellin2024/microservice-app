package sem4.pro.test.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sem4.pro.test.dto.CategoriesDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private Long id;
	
	private String productName;
	
	private String productDescription;
	
	private String productCode;
	
	private CategoriesDto categoriesDto;
	
	
	
}
