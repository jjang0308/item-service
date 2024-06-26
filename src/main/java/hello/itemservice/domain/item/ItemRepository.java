package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new ConcurrentHashMap<>(); //static
    private static long sequence = 0L; //static


    // Create Read Update Delete : CRUD
    //저장
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    //조회
    public Item findById(Long id){
        return store.get(id);
    }

    //전체 조회
    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    //수정
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    //전체 삭제
    public void clearStore(){
        store.clear();
    }

}
