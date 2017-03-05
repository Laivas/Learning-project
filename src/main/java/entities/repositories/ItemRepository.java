package entities.repositories;

import java.util.List;

import entities.Item;

public interface ItemRepository {

	public void insertOrUpdate(Item item);
	
	public void delete(Item item);
	
	public void deleteById(Long bookId);
	
	public List<Item> findByTitle(String title);
	
	public int countAllItems();
	
	
	
}
