package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.ShiroConfig.ShiroEncryption;
import com.outsourcing.combat.Service.TUserService;
import com.outsourcing.combat.mapper.TUserMapper;
import com.outsourcing.combat.pojo.TUser;
import com.outsourcing.combat.pojo.user_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "TUser")
public class TUserServiceImpl implements TUserService {

    @Autowired
    TUserMapper tUserMapper;

    //添加
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tUser='")
    public PageInfo<user_role> getInsert(TUser tUser) {
        String password = ShiroEncryption.shiroEncryption(tUser.getPassword(), tUser.getSalt());
        tUser.setPassword(password);
        tUserMapper.getInsert(tUser);
        return new PageInfo<>(tUserMapper.getTUser());
    }

    //查询所有
    @Override
    @Transactional
    @Cacheable(key = "'tUser='")
    public PageInfo<user_role> getTUser() {
        return new PageInfo<>(tUserMapper.getTUser());
    }

    //查询未删除
    @Override
    @Transactional
    @Cacheable(key = "'Select='+#currentPage+'--'+#pageSize")
    public PageInfo<user_role> getSelect(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(tUserMapper.getSelect());
    }

    //查询回收站
    @Override
    @Transactional
    @Cacheable(key = "'Delete='+#currentPage+'--'+#pageSize")
    public PageInfo<user_role> getSelectDelete(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(tUserMapper.getSelectDelete());
    }

    //根据id查询
    @Override
    @Transactional
    @Cacheable(key = "'Select-id='+#id")
    public PageInfo<user_role> getSelectById(Integer id) {
        return new PageInfo<>(tUserMapper.getSelectById(id));
    }

    //根据id查询回收站
    @Override
    @Transactional
    @Cacheable(key = "'Delete-id='+#id")
    public PageInfo<user_role> getSelectDeleteById(Integer id) {
        return new PageInfo<>(tUserMapper.getSelectDeleteById(id));
    }

    //根据name查询
    @Override
    @Transactional
    @Cacheable(key = "'Select-name='+#name+#currentPage+'--'+#pageSize")
    public PageInfo<user_role> getSelectByName(String name, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(tUserMapper.getSelectByName(name));
    }

    //根据userId查询
    @Override
    @Transactional
    @Cacheable(key = "'Select-userId='+#userId+#currentPage+'--'+#pageSize")
    public PageInfo<user_role> getSelectByUserId(Integer userId, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(tUserMapper.getSelectByUserId(userId));
    }

    //根据id假删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tUser='")
    public PageInfo<user_role> getDeleteById(Integer id) {
        tUserMapper.getDeleteById(id);
        return new PageInfo<>(tUserMapper.getTUser());
    }

    //根据id真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tUser'")
    public PageInfo<user_role> getClearById(Integer id) {
        tUserMapper.getClearById(id);
        return new PageInfo<>(tUserMapper.getTUser());
    }

    //全部真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tUser'")
    public PageInfo<user_role> getClear() {
        tUserMapper.getClear();
        return new PageInfo<>(tUserMapper.getTUser());
    }

    //根据id还原
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tUser'")
    public PageInfo<user_role> getReplyById(Integer id) {
        tUserMapper.getReplyById(id);
        return new PageInfo<>(tUserMapper.getTUser());
    }

    //根据id更新
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tUser'")
    public PageInfo<user_role> getUpdateById(TUser tUser) {
        if ((tUser.getPassword() != null && tUser.getPassword() != "") || (tUser.getName() != null && tUser.getName() != "")) {
            String password = ShiroEncryption.shiroEncryption(tUser.getPassword(), tUser.getSalt());
            tUser.setPassword(password);
        } else {
            tUser.setPassword(null);
        }

        tUserMapper.getUpdateById(tUser);
        return new PageInfo<>(tUserMapper.getTUser());
    }
}
