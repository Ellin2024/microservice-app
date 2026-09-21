package sem4.cal.test.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
	
	private String categoryName;
	
	private String categoryDescription;

}
