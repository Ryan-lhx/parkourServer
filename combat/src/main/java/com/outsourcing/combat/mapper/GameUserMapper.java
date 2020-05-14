package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.GameUser;

import java.util.List;
import java.util.Map;

public interface GameUserMapper {
    //添加游戏用户
    void getInsert(GameUser gameUser);

    //查询所有
    List<GameUser> getSelect();

    //查询所有没有被删除
    List<GameUser> getSelectGameUser();

    //查询所有被删除的（回收站）
    List<GameUser> getSelectDelete();

    //根据id查看回收站
    List<GameUser> getSelectDeleteById(Integer id);

    //估计Id查询
    List<GameUser> getSelectById(Integer id);

    //根据UserName（游戏姓名）查询
    List<GameUser> getSelectByUserName(String userName);

    //根据UserIntegral（游戏积分）范围查询
    List<GameUser> getSelectByUserIntegral(Integer integral, Integer integral1);

    //判断是否为VIP
    List<GameUser> getSelectByUserVIP(Integer VIP);

    //根据UserDistance（游戏距离）范围查询
    List<GameUser> getSelectByUserDistance(Integer distance, Integer distance1);

    //根据游戏nickname（昵称）查询
    List<GameUser> getSelectByUserNickname(String nickname);
    //任务查询 我写在UserTask表
//    List<GameUser> getSelectByUserTask(String task);
    //查看游戏背包 我会写在UserBackpack表
//    List<GameUser> geteSelectByUserBackpack(Integer backpack);

    //根据id假删除
    void getDeleteById(Integer id);

    //根据其他字段删除
    void getDeleteByGameUser(GameUser gameUser);

    //根据id真删除
    void getClearById(Integer id);

    //全部真删除
    void getClear();

    //根据id还原
    void getReplyById(Integer id);

    //根据id更新
    void getUpdateById(GameUser gameUser);
}
