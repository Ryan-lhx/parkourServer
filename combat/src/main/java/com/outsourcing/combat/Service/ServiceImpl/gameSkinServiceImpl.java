package com.outsourcing.combat.Service.ServiceImpl;


import com.outsourcing.combat.Service.gameSkinService;
import com.outsourcing.combat.mapper.gameSkinMapper;
import com.outsourcing.combat.pojo.gameSkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@CacheConfig(cacheNames = "GAMESKIN")
@Service
public class gameSkinServiceImpl implements gameSkinService {
    @Autowired
    com.outsourcing.combat.mapper.gameSkinMapper gameSkinMapper;

    @Cacheable(key = "'ALL'+'--'+#currentPage+'--'+#pageSize")
    @Override
    public List<gameSkin> getGameSkinAll(Integer currentPage, Integer pageSize) {
        System.out.println("进入service中");
        return gameSkinMapper.getGameSkinAll();
    }

    @Caching(
            cacheable = {
                    @Cacheable(key = "'GameSkinId='+#id+'--'+#currentPage+'--'+#pageSize")
            },
            put = {
                    @CachePut(key = "'GameSkinId='+#id+'--'+#currentPage+'--'+#pageSize")

            })
    @Override
    public gameSkin getGameSkinById(Integer id, Integer currentPage, Integer pageSize) {
        return gameSkinMapper.getGameSkinById(id);
    }

    @Override
    public List<gameSkin> getGameSkinBySkinNameVague(String vagueName) {
        return gameSkinMapper.getGameSkinBySkinNameVague(vagueName);
    }

    @Override
    public List<gameSkin> getGameSkinBySkinDescriptionVague(String description) {
        return gameSkinMapper.getGameSkinBySkinNameVague(description);
    }

    @Override
    public gameSkin getGameSkinByModelId(Integer modelId) {
        return gameSkinMapper.getGameSkinByModelId(modelId);
    }

    @Transactional
    @Override
    public Integer insertGameSkin(gameSkin gameSkin) {
        return gameSkinMapper.insertGameSkin(gameSkin);
    }

    @Override
    public Integer updateGameSkin(gameSkin gameSkin) {
        return gameSkinMapper.updateGameSkin(gameSkin);
    }

    @CacheEvict(key = "'GameSkinId='+#id+'--'+#currentPage+'--'+#pageSize")
    @Override
    public Integer deleteGameSkinById(Integer id, Integer currentPage, Integer pageSize) {
        return gameSkinMapper.deleteGameSkinById(id);
    }

    @Override
    public Integer selectCounts() {
        return gameSkinMapper.selectCounts();
    }
}
