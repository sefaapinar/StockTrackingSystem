package com.StokTakip.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StokTakip.Model.Category;
import com.StokTakip.Repository.CategoryDataRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDataRepository categoryDataRepository;
	
	
	
	@Override
	public void createCategory(Category category) {
		categoryDataRepository.save(category);
		
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryDataRepository.getOne(id);
	}

	@Override
	public void updateCategory(Category category) {
		
	}

	@Override
	public void deleteCategory(int id) {
		categoryDataRepository.deleteById(id);
		
	}


	@Override
	public List<Category> getAllCategories() {
		List<Category> list=categoryDataRepository.findAll();
		return list;
	}

	@Override
	public long getCategoryCount() {
		return categoryDataRepository.count();
	}

	@Override
	public boolean isExists(int id) {
	return categoryDataRepository.existsById(id);
		
	}

}
