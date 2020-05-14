package com.outsourcing.combat.mapper;


import com.outsourcing.combat.pojo.store;

import java.util.List;


public interface storeMapper {
    // 查询所有
    List<store> getStoreAll();

    // 根据id查询
    store getStoreById(Integer id);

    // 根据storeName模糊查询
    List<store> getStoreByVagueName(String name);

    // 根据storeSort模糊查询
    List<store> getStoreByStoreSort(String storeSort);

    // 根据storeShelvesTime模糊查询
    List<store> getStoreShelvesTime(String storeShelvesTime);

    // 根据storeTakeTimeVague进行模糊查询
    List<store> getStoreTakeTimeVague(String storeTakeTimeVague);

    // 查出modelId的所有商品
    List<store> getAllByModelId(Integer modelId);

    // 添加商品
    Integer insertStore(store store);

    // 修改商品
    Integer alterStore(store store);

    // 根据id删除商品
    Integer deleteStoreById(Integer id);
}
