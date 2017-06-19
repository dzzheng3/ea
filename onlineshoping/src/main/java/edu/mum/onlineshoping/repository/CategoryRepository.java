package edu.mum.onlineshoping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlineshoping.model.Category;


@Repository
public interface CategoryRepository extends  CrudRepository<Category, Long>{
		/*public void saveCategory(Category category);
		public List<Category>getAll();
		public List<Category> getByName(String name);*/
}
