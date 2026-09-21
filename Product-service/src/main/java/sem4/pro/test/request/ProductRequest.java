package sem4.pro.test.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
	
	private String productName;
	
	private String productDescription;
	
	private String productCode;
	
	private Long categoryId;

}
