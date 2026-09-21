package sem4.cal.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sem4.cal.test.model.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long>
{

}
