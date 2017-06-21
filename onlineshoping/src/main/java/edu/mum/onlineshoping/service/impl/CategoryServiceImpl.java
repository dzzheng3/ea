package edu.mum.onlineshoping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.onlineshoping.model.Category;
import edu.mum.onlineshoping.repository.CategoryRepository;
import edu.mum.onlineshoping.service.CategoryService;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long key) {
		return categoryRepository.findOne(key);
	}

	@Override
	public void add(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
		
	}
	public List<Category> findByCategoryName(String name) {
		return categoryRepository.findByCategoryName(name);
		
	}

}
