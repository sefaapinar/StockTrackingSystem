package com.StokTakip.Service;

import java.util.List;

import com.StokTakip.Model.Store;


public interface StoreService {
	public void createStore(Store store);
	public Store getStoreById(int id);
	public void updateStore(Store store);
	public void deleteStore(int id);
	public List<Store> getAllStores();
	public long getStoreCount();
	public boolean isExists(int id);
}
