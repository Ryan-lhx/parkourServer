package com.outsourcing.combat.Service.ServiceImpl;


import com.outsourcing.combat.Service.StoreService;
import com.outsourcing.combat.mapper.storeMapper;
import com.outsourcing.combat.pojo.store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "STORE")
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    storeMapper storeMapperAuto;

    @Cacheable(key = "'ALL'+'--'+#currentPage+'--'+#pageSize")
    @Override
    public List<store> getStoreAll(Integer currentPage, Integer pageSize) {
        return storeMapperAuto.getStoreAll();
    }

    @Cacheable(key = "'storeId='+#id+'--'+#currentPage+'--'+#pageSize")
    @Override
    public store getStoreById(Integer id, Integer currentPage, Integer pageSize) {
        return storeMapperAuto.getStoreById(id);
    }

    @Override
    public List<store> getStoreByVagueName(String name) {
        return storeMapperAuto.getStoreByVagueName(name);
    }

    @Override
    public List<store> getStoreByStoreSort(String storeSort) {
        return storeMapperAuto.getStoreByStoreSort(storeSort);
    }

    @Override
    public List<store> getStoreShelvesTime(String storeShelvesTime) {
        return storeMapperAuto.getStoreShelvesTime(storeShelvesTime);
    }

    @Override
    public List<store> getStoreTakeTimeVague(String storeTakeTimeVague) {
        return storeMapperAuto.getStoreTakeTimeVague(storeTakeTimeVague);
    }

    @Override
    public List<store> getAllByModelId(Integer modelId) {
        return storeMapperAuto.getAllByModelId(modelId);
    }

    @Override
    public Integer insertStore(store store) {
        return storeMapperAuto.insertStore(store);
    }

    @Override
    public Integer alterStore(store store) {
        return storeMapperAuto.alterStore(store);
    }

    @CacheEvict(key = "'storeId='+#id+'--'+#currentPage+'--'+#pageSize")
    @Override
    public Integer deleteStoreById(Integer id, Integer currentPage, Integer pageSize) {
        return storeMapperAuto.deleteStoreById(id);
    }
}
