package com.outsourcing.combat.Service;

import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.pojo.GameUser;

import java.util.List;

public interface GameUserService {
    //添加游戏用户
    PageInfo<GameUser> getInsertGameUser(GameUser gameUser);

    //查询所有
    PageInfo<GameUser> getSelect();

    //查询所有没有被删除
    PageInfo<GameUser> getSelectGameUser(Integer currentPage, Integer pageSize);

    //查询所有被删除的（回收站）
    PageInfo<GameUser> getSelectDelete(Integer currentPage, Integer pageSize);

    //根据id查看回收站
    PageInfo<GameUser> getSelectDeleteById(Integer id);

    //估计Id查询
    PageInfo<GameUser> getSelectById(Integer id);

    //根据UserName（游戏姓名）查询
    PageInfo<GameUser> getSelectByUserName(String userName, Integer currentPage, Integer pageSize);

    //根据UserIntegral（游戏积分）范围查询
    PageInfo<GameUser> getSelectByUserIntegral(Integer integral, Integer integral1, Integer currentPage, Integer pageSize);

    //判断是否为VIP
    PageInfo<GameUser> getSelectByUserVIP(Integer VIP, Integer currentPage, Integer pageSize);

    //根据UserDistance（游戏距离）范围查询
    PageInfo<GameUser> getSelectByUserDistance(Integer distance, Integer distance1, Integer currentPage, Integer pageSize);

    //根据游戏nickname（昵称）查询
    PageInfo<GameUser> getSelectByUserNickname(String nickname, Integer currentPage, Integer pageSize);

    //根据id假删除
    PageInfo<GameUser> getDeleteById(Integer id);

    //根据其他字段删除
    PageInfo<GameUser> getDeleteByGameUser(GameUser gameUser);

    //根据id真删除
    PageInfo<GameUser> getClearById(Integer id);

    //全部真删除
    PageInfo<GameUser> getClear();

    //根据id还原
    PageInfo<GameUser> getReplyById(Integer id);

    //根据id更新
    PageInfo<GameUser> getUpdateById(GameUser gameUser);
}
