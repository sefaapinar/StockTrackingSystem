package com.StokTakip.Service;

import java.util.List;

import com.StokTakip.Model.Category;



public interface CategoryService {

	public void createCategory(Category category);
	public Category getCategoryById(int id);
	public void updateCategory(Category category);
	public void deleteCategory(int id);
	public List<Category> getAllCategories();
	public long getCategoryCount();
	public boolean isExists(int id);
}
