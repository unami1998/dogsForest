package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

//    public Item findById(int itemId){
//        return itemRepository.findById(itemId);
//    }

    public void updateItemName(int id, String newName) {
        Optional<Item> FinditemId = itemRepository.findById(id);
        FinditemId.ifPresent(item -> {
            item.setItemName(newName);
            itemRepository.save(item);
        });
    }
}
