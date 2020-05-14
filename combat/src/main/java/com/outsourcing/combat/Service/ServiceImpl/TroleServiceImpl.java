package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.TroleService;
import com.outsourcing.combat.mapper.TroleMapper;
import com.outsourcing.combat.pojo.GameTask;
import com.outsourcing.combat.pojo.TRole;
import com.outsourcing.combat.pojo.MenuRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;
import java.util.List;

@Service
@CacheConfig(cacheNames = "'TRole'")
public class TroleServiceImpl implements TroleService {

    @Autowired
    TroleMapper tRoleMapper;

    //添加
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tRole'")
    public PageInfo<MenuRole> getInsert(TRole tRole) {
        tRoleMapper.getInsert(tRole);
        return new PageInfo<>(tRoleMapper.getSelect());
    }

    //查询所有
    @Override
    @Transactional
    @Cacheable(key = "'tRole'")
    public PageInfo<MenuRole> getSelect() {
        return new PageInfo<>(tRoleMapper.getSelect());
    }

    //查询未删除
    @Override
    @Transactional
    @Cacheable(key = "'Select='+#currentPage+'--'+#pageSize")
    public PageInfo<MenuRole> getSelectMenuRole(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(tRoleMapper.getSelectMenuRole());
    }

    //查询回收站
    @Override
    @Transactional
    @Cacheable(key = "'Delete='+#currentPage+'--'+#pageSize")
    public PageInfo<MenuRole> getSelectDelete(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(tRoleMapper.getSelectDelete());
    }

    //根据id查询
    @Override
    @Transactional
    @Cacheable(key = "'Select-id='+#id")
    public PageInfo<MenuRole> getSelectById(Integer id) {
        return new PageInfo<>(tRoleMapper.getSelectById(id));
    }

    //根据id查询回收站
    @Override
    @Transactional
    @Cacheable(key = "'Delete-id='+#id")
    public PageInfo<MenuRole> getSelectDeleteById(Integer id) {
        return new PageInfo<>(tRoleMapper.getSelectDeleteById(id));
    }

    //根据roleId查询
    @Override
    @Transactional
    @Cacheable(key = "'roleId='+#roleId+#currentPage+'--'+#pageSize")
    public PageInfo<MenuRole> getSelectByRoleId(Integer roleId, Integer currentPage, Integer pageSize) {
        return new PageInfo<>(tRoleMapper.getSelectByRoleId(roleId));
    }

    //根据roleName查询
    @Override
    @Transactional
    @Cacheable(key = "'roleName='+#roelName+#currentPage+'--'+#pageSize")
    public PageInfo<MenuRole> getSelectByRoleName(String roelName, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(tRoleMapper.getSelectByRoleName(roelName));
    }

    //根据depiction查询
    @Override
    @Transactional
    @Cacheable(key = "'depiction='+#depiction+#currentPage+'--'+#pageSize")
    public PageInfo<MenuRole> getSelectByDepiction(String depiction, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(tRoleMapper.getSelectByDepiction(depiction));
    }

    //根据id更新
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tRole'")
    public PageInfo<MenuRole> getUpdateById(TRole tRole) {
        tRoleMapper.getUpdateById(tRole);
        return new PageInfo<>(tRoleMapper.getSelect());
    }

    //根据id假删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tRole'")
    public PageInfo<MenuRole> getDeleteById(Integer id) {
        tRoleMapper.getDeleteById(id);
        return new PageInfo<>(tRoleMapper.getSelect());
    }

    //根据id真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tRole'")
    public PageInfo<MenuRole> getClearById(Integer id) {
        tRoleMapper.getClearById(id);
        return new PageInfo<>(tRoleMapper.getSelect());
    }

    //全部真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tRole'")
    public PageInfo<MenuRole> getClear() {
        tRoleMapper.getClear();
        return new PageInfo<>(tRoleMapper.getSelect());
    }

    //根据id还原
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'tRole'")
    public PageInfo<MenuRole> getReplyById(Integer id) {
        tRoleMapper.getReplyById(id);
        return new PageInfo<>(tRoleMapper.getSelect());
    }
}
