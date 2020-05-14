package com.outsourcing.combat.Service.ServiceImpl;

import java.util.List;

import com.outsourcing.combat.Service.question_bankService;
import com.outsourcing.combat.mapper.question_bankMapper;
import com.outsourcing.combat.pojo.question_bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@CacheConfig(cacheNames = "qBank")
@Service
public class question_bankServiceImpl implements question_bankService {

    @Autowired
    question_bankMapper q_bankMapper;


    @Override
    @Cacheable(key = "'ALL'+'--'+#currentPage+'--'+#pageSize")
    public List<question_bank> getByAll(Integer currentPage,  Integer pageSize) {
        return q_bankMapper.getByAll();
    }

    @Override
    @CachePut(key = "'qID'+'--'+#id", unless = "#result == null")
    public question_bank getSelectById(Integer id) {
        // TODO Auto-generated method stub
        return q_bankMapper.getSelectById(id);
    }

    @Override
    public question_bank getSelectByTitle(String title) {
        return q_bankMapper.getSelectByTitle(title);
    }

    @Override
    public List<question_bank> getSelectByTitleVague(String vagueTitle) {
        return q_bankMapper.getSelectByTitleVague(vagueTitle);
    }

    @Override
    @Cacheable(key = "'Sort'+'--'+#sortData")
    public question_bank getSelectBySort(Integer sortData) {
        return q_bankMapper.getSelectBySort(sortData);
    }

    @Override
    @Cacheable(key = "'Difficult'+'--'+#currentPage+'--'+#pageSize")
    public List<question_bank> getSelectByDifficult(String difficult,Integer currentPage,  Integer pageSize) {
        return q_bankMapper.getSelectByDifficult(difficult);
    }

    @Caching(
            cacheable = {
                    @Cacheable(key = "'AllQuestion'+'--'+#currentPage+'--'+#pageSize")
            },
            put = {
                    @CachePut(key = "'AllQuestion'+'--'+#currentPage+'--'+#pageSize")
            })
    @Override
    public List<question_bank> getSelectAllQuestion(Integer currentPage,  Integer pageSize) {
        // TODO Auto-generated method stub
        return q_bankMapper.getSelectAllQuestion();
    }

    @Transactional
    @Override
    public Integer setInsertQuestion(question_bank qBank) {
        // TODO Auto-generated method stub
        return q_bankMapper.setInsertQuestion(qBank);
    }

    @CachePut(value = "recycle", key = "'question_bank_clear'+#id", unless = "#result == null")
    @Override
    public Integer clearQuestionById(Integer id) {
        return q_bankMapper.clearQuestionById(id);
    }

    @Override
    public Integer setUpdateQuestion(question_bank qBank) {
        // TODO Auto-generated method stub
        return q_bankMapper.setUpdateQuestion(qBank);
    }

    @CacheEvict(value = "recycle", beforeInvocation = true, key = "'question_bank_clear'+#id")
    @Override
    public Integer deleteQuestionById(Integer id, String KeyList) {
        // TODO Auto-generated method stub
//        System.out.println("在serviceImpl中的KeyList的值是" + KeyList);
//        System.out.println("开始测试。。。。。");
        return q_bankMapper.deleteQuestionById(id);
    }

    @Caching(
//            cacheable = {
//				@Cacheable(value = "recycler",key = "'question_bank_clear'+#id", unless = "#result == null")
//			},
//			put = {
//            	@CachePut(value = "recycle",key = "'question_bank_clear'+#id", unless = "#result == null")
//    		}

            evict = {
                    @CacheEvict(value = "recycle", beforeInvocation = true, key = "'question_bank_clear'+#id")
            })
    @Override
    public Integer regainQuestionById(Integer id) {
        System.out.println("开始恢复数据regainQuestionById。。。。。。。。");
        Integer result = q_bankMapper.regainQuestionById(id);
        System.out.println("数据恢复完成。。。。。。。。。");
        return result;
    }

    @CacheEvict(key = "selectCounts")
    @Override
    public Integer selectCounts() {
        return q_bankMapper.selectCounts();
    }

}
