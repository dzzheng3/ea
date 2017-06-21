package edu.mum.onlineshoping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.onlineshoping.model.Category;


@Repository
public interface CategoryRepository extends  CrudRepository<Category, Long>{
		/*public void saveCategory(Category category);
		public List<Category>getAll();
		public List<Category> getByName(String name);*/
	@Query("select c from Category c where c.cName = :cName")
	List<Category> findByCategoryName(@Param("cName") String cName);
}
