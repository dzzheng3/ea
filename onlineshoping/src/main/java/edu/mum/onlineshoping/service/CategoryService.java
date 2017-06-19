package edu.mum.onlineshoping.service;

import java.util.List;

import edu.mum.onlineshoping.model.Category;

public interface CategoryService {
	public List<Category> getAll();
	public Category getCategoryById(Long key);
	public void add(Category category);
	public void delete(Long id);

}
