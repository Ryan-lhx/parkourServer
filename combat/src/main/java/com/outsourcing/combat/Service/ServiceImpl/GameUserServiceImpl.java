package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.GameUserService;
import com.outsourcing.combat.ShiroConfig.ShiroEncryption;
import com.outsourcing.combat.mapper.GameUserMapper;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.pojo.GameUser;
import com.outsourcing.combat.utils.MsgUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@CacheConfig(cacheNames = "GameUser")
public class GameUserServiceImpl implements GameUserService {

    @Autowired
    GameUserMapper gameUserMapper;

    //添加
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameUser'")
    public PageInfo<GameUser> getInsertGameUser(GameUser gameUser) {
        String password = ShiroEncryption.shiroEncryption(gameUser.getUserPassword(), gameUser.getUserName());
        gameUser.setUserPassword(password);
        gameUserMapper.getInsert(gameUser);
        return new PageInfo<>(gameUserMapper.getSelect());
    }

    //查询所有
    @Override
    @Transactional
    @Cacheable(key = "'GameUser'")
    public PageInfo<GameUser> getSelect() {
        return new PageInfo<>(gameUserMapper.getSelect());
    }

    //查询所有未删除
    @Override
    @Transactional
    @Cacheable(key = "'Select'+#currentPage+'--'+#pageSize")
    public PageInfo<GameUser> getSelectGameUser(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameUser> selectGameUser = gameUserMapper.getSelectGameUser();
        return new PageInfo<>(selectGameUser);
    }

    //查询所有被删除（回收站）
    @Override
    @Transactional
    @Cacheable(key = "'Delete'+#currentPage+'--'+#pageSize")
    public PageInfo<GameUser> getSelectDelete(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameUser> selectDelete = gameUserMapper.getSelectDelete();
        return new PageInfo<>(selectDelete);
    }

    //根据id查询回收站
    @Override
    @Transactional
    @Cacheable(key = "'Select-id='+#id")
    public PageInfo<GameUser> getSelectDeleteById(Integer id) {
        return new PageInfo<>(gameUserMapper.getSelectDeleteById(id));
    }

    //根据id查询
    @Override
    @Transactional
    @Cacheable(key = "'Delete-id='+#id")
    public PageInfo<GameUser> getSelectById(Integer id) {
        return new PageInfo<>(gameUserMapper.getSelectById(id));
    }

    //根据userName查询
    @Override
    @Transactional
    @Cacheable(key = "'userName='+#userName+#currentPage+'--'+#pageSize")
    public PageInfo<GameUser> getSelectByUserName(String userName, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameUser> selectByUserName = gameUserMapper.getSelectByUserName(userName);
        return new PageInfo<>(selectByUserName);
    }

    //根据游戏积分范围查询
    @Override
    @Transactional
    @Cacheable(key = "'integral='+#integral+'~~~'+#integral1+#currentPage+'--'+#pageSize")
    public PageInfo<GameUser> getSelectByUserIntegral(Integer integral, Integer integral1, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameUser> selectByUserIntegral = gameUserMapper.getSelectByUserIntegral(integral, integral1);
        return new PageInfo<>(selectByUserIntegral);
    }

    //根据VIP查询
    @Override
    @Transactional
    @Cacheable(key = "'VIP'+#VIP+#currentPage+'--'+#pageSize")
    public PageInfo<GameUser> getSelectByUserVIP(Integer VIP, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameUser> selectByUserVIP = gameUserMapper.getSelectByUserVIP(VIP);
        return new PageInfo<>(selectByUserVIP);
    }

    //根据distance范围查询
    @Override
    @Transactional
    @Cacheable(key = "'GAMEUSER-distance='+#distance+'~~~'+#distance1+#currentPage+'--'+#pageSize")
    public PageInfo<GameUser> getSelectByUserDistance(Integer distance, Integer distance1, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameUser> selectByUserDistance = gameUserMapper.getSelectByUserDistance(distance, distance1);
        return new PageInfo<>(selectByUserDistance);
    }

    //根据nickname模糊查询
    @Override
    @Transactional
    @Cacheable(key = "'GAMEUSER-Nickname='+#nickname+#currentPage+'--'+#pageSize")
    public PageInfo<GameUser> getSelectByUserNickname(String nickname, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<GameUser> selectByUserNickname = gameUserMapper.getSelectByUserNickname(nickname);
        return new PageInfo<>(selectByUserNickname);

    }


    /*@Override
    @Transactional
    @Cacheable(key = "'GAMEUSER-'")
    public PageInfo<GameUser> getSelectByUserTask(String task) {
        return null;
    }
*/
  /*  @Override
    public PageInfo<GameUser> geteSelectByUserBackpack(Integer backpack) {
        return null;
    }
*/

    //根据id假删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameUser'")
    public PageInfo<GameUser> getDeleteById(Integer id) {
        gameUserMapper.getDeleteById(id);
        return new PageInfo<>(gameUserMapper.getSelect());
    }

    //根据其他字段删除
    @Override
    public PageInfo<GameUser> getDeleteByGameUser(GameUser gameUser) {
        return null;
    }

    //根据其他字段假删除
/*    @Override
    @Transactional
    @CacheEvict(allEntries = true,beforeInvocation = true)
    @CachePut(key = "'GAMEUSER-Select'")
    public PageInfo<GameUser> getDeleteByGameUser(GameUser gameUser) {
        return null;
    }*/

    //根据id真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameUser'")
    public PageInfo<GameUser> getClearById(Integer id) {
        gameUserMapper.getClearById(id);
        return new PageInfo<>(gameUserMapper.getSelect());
    }

    //全部真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameUser'")
    public PageInfo<GameUser> getClear() {
        gameUserMapper.getClear();
        return new PageInfo<>(gameUserMapper.getSelect());
    }

    //根据id还原
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameUser'")
    public PageInfo<GameUser> getReplyById(Integer id) {
        gameUserMapper.getReplyById(id);
        return new PageInfo<>(gameUserMapper.getSelect());
    }

    //根据id更新
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'GameUser'")
    public PageInfo<GameUser> getUpdateById(GameUser gameUser) {
        if ((gameUser.getUserPassword() != null && gameUser.getUserPassword() != "") && (gameUser.getUserName() != null && gameUser.getUserName() != "")) {
            gameUser.setUserPassword(ShiroEncryption.shiroEncryption(gameUser.getUserPassword(), gameUser.getUserName()));
        } else {
            gameUser.setUserPassword(null);
        }
        gameUserMapper.getUpdateById(gameUser);
        return new PageInfo<>(gameUserMapper.getSelect());
    }
}
