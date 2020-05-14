package com.outsourcing.combat.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.outsourcing.combat.Service.PropsService;
import com.outsourcing.combat.mapper.PropsMapper;
import com.outsourcing.combat.pojo.Props;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "Props")
public class PropsServiceImpl implements PropsService {

    @Autowired
    PropsMapper propsMapper;

    //添加
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'Props'")
    public PageInfo<Props> getInsert(Props props) {
        propsMapper.getInsert(props);
        return new PageInfo<>(propsMapper.getProps());
    }

    //查看所有
    @Override
    @Transactional
    @Cacheable(key = "'Props'")
    public PageInfo<Props> getProps() {
        return new PageInfo<>(propsMapper.getProps());
    }

    //查看未删除
    @Override
    @Transactional
    @Cacheable(key = "'Select='+#currentPage+'--'+#pageSize")
    public PageInfo<Props> getSelect(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Props> select = propsMapper.getSelect();
        return new PageInfo<>(select);
    }

    //查看删除的（回收站）
    @Override
    @Transactional
    @Cacheable(key = "'Delete='+#currentPage+'--'+#pageSize")
    public PageInfo<Props> getSelectDelete(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Props> selectDelete = propsMapper.getSelectDelete();
        return new PageInfo<>(selectDelete);
    }

    //根据id查看回收站
    @Override
    @Transactional
    @Cacheable(key = "'PROPS-id='+#id")
    public PageInfo<Props> getSelectDeleteById(Integer id) {
        return new PageInfo<>(propsMapper.getSelectDeleteById(id));
    }

    //根据id查看
    @Override
    @Transactional
    @Cacheable(key = "'PROPS-id='+#id")
    public PageInfo<Props> getSelectById(Integer id) {
        return new PageInfo<>(propsMapper.getSelectById(id));
    }

    //根据name查询
    @Override
    @Transactional
    @Cacheable(key = "'name='+#name+#currentPage+'--'+#pageSize")
    public PageInfo<Props> getSelectByName(String name, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Props> selectByName = propsMapper.getSelectByName(name);
        return new PageInfo<>(selectByName);
    }

    //根据description查询
    @Override
    @Transactional
    @Cacheable(key = "'description='+#description+#currentPage+'--'+#pageSize")
    public PageInfo<Props> getSelectByDescription(String description, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Props> selectByDescription = propsMapper.getSelectByDescription(description);
        return new PageInfo<>(selectByDescription);
    }

    //根据Sort查询
    @Override
    @Transactional
    @Cacheable(key = "'sort='+#sort+#currentPage+'--'+#pageSize")
    public PageInfo<Props> getSelectBySort(String sort, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Props> selectBySort = propsMapper.getSelectBySort(sort);
        return new PageInfo<>(selectBySort);
    }

    //根据id假删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'Props'")
    public PageInfo<Props> getDeleteById(Integer id) {
        propsMapper.getDeleteById(id);
        return new PageInfo<>(propsMapper.getProps());
    }

    //根据id真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'Props'")
    public PageInfo<Props> getClearById(Integer id) {
        propsMapper.getClearById(id);
        return new PageInfo<>(propsMapper.getProps());
    }

    //根据id回复
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'Props'")
    public PageInfo<Props> getReplyById(Integer id) {
        propsMapper.getReplyById(id);
        return new PageInfo<>(propsMapper.getProps());
    }

    //全部真删除
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'Props'")
    public PageInfo<Props> getClear() {
        propsMapper.getClear();
        return new PageInfo<>(propsMapper.getProps());
    }

    //根据id更新
    @Override
    @Transactional
    @CacheEvict(allEntries = true, beforeInvocation = true)
    @CachePut(key = "'Props'")
    public PageInfo<Props> getUpdateById(Props props) {
        propsMapper.getUpdateById(props);
        return new PageInfo<>(propsMapper.getSelect());
    }
}
