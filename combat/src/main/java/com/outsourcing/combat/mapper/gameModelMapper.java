package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.gameModel;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@CacheConfig(cacheNames = "GAMEMODEL")
@Mapper
public interface gameModelMapper {

    // 查询所有
    @Cacheable(key = "'ALL'+'--'+#currentPage+'--'+#pageSize")
    @Select("SELECT * FROM game_model")
    public List<gameModel> getAll(Integer currentPage, Integer pageSize);

    // 根据id查询游戏模型
    @Caching(put = {
            @CachePut(key = "'id'+#id", unless = "#result == null"),
            @CachePut(key = "'modelName'+#result.modelName", unless = "#result == null ")
    })
    @Select("SELECT * FROM game_model WHERE id=#{id}")
    public gameModel getGameModelById(Integer id);

    // 根据modelName查询
    @Cacheable(key = "'modelName'+#modelName")
    @Select("SELECT * FROM game_model WHERE Model_Name like #{modelName}")
    public gameModel getGameModelByModelName(String modelName);

    // 根据modelSort查询
    @Select("SELECT * FROM game_model WHERE Model_Sort like #{sortData}")
    public gameModel getGameModelBySort(String sortData);

    // 添加gameModel
    @Transactional
    @Insert("INSERT DELAYED INTO game_model (id, Model_Name,Model_Sort,Model_Url,Model_Add_Time,Model_Change_Time) " +
            "VALUES (#{id},#{modelName},#{modelSort},#{modelUrl},#{modelAddTime},#{modelChangeTime})")
    public Integer insertGameModel(gameModel model);

    // 将gameModel放入回收站,根据id
    @Transactional
    @Update("UPDATE game_model SET delete1=0 WHERE id=#{id}")
    public Integer insertRegainGameById(Integer id);

    // 根据modelName将gameModel放入回收站
    @Update("UPDATE game_model SET delete1=0 WHERE Model_Name=#{modelName}")
    public Integer updateRegainByName(String modelName);

    // 查询回收站里的gameModel,状态值为0表示在回收站里面
    @Select("SELECT * FROM game_model WHERE delete1=0")
    public List<gameModel> getRegainGameModelByDelete1();

    // 根据gameName将gameModel从回收站删除
    @Delete("DELETE FROM game_model WHERE delete1=0 AND Model_Name=#{modelName}")
    public Integer deleteRegainByModelName(String modelName);

    // 从回收站中删除gameModel，根据id删除
    @Caching(
            evict = {
                    @CacheEvict(key = "'id'+#id"),
                    @CacheEvict(key = "'modelName'+#result.modelName")
            }
    )
    @Delete("DELETE FROM game_model WHERE id=#{id}")
    public Integer deleteGameModelById(Integer id);

    // 更新gameModel的相关信息
    @Transactional
    @Update("UPDATE game_model SET Model_Name=#{modelName},Model_Sort=#{modelSort},Model_Url=#{modelUrl},Model_Add_Time=#{modelAddTime},Model_Change_Time=#{modelChangeTime}" +
            " WHERE id=#{id}")
    public Integer updateGameModel(gameModel gModel);
}
