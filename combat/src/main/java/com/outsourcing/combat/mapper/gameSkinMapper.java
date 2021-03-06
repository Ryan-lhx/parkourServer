package com.outsourcing.combat.mapper;


import com.outsourcing.combat.pojo.gameSkin;

import java.util.List;

public interface gameSkinMapper {

    // 查询所有
    List<gameSkin> getGameSkinAll();

    // 根据id查询
    gameSkin getGameSkinById(Integer id);

    // 根据skinName进行模糊查找
    List<gameSkin> getGameSkinBySkinNameVague(String vagueName);

    // 根据description进行模糊查找
    List<gameSkin> getGameSkinBySkinDescriptionVague(String description);

    //根据modelId进行精确查找
    gameSkin getGameSkinByModelId(Integer modelId);

    // 添加游戏皮肤
    Integer insertGameSkin(gameSkin gameSkin);

    // 根据id修改相关游戏皮肤的信息
    Integer updateGameSkin(gameSkin gameSkin);

    // 根据id删除游戏皮肤
    Integer deleteGameSkinById(Integer id);

    // 查出总共有多少个皮肤
    Integer selectCounts();
}
