package com.outsourcing.combat.mapper;

import com.outsourcing.combat.pojo.answer;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@CacheConfig(cacheNames = "ANSWER")
@Mapper
public interface answerMapper {

    // 查询全部
    @Cacheable(key = "'ALL'+'--'+#currentPage+'--'+#pageSize")
    @Select("SELECT * FROM answer")
    public List<answer> getAll(Integer currentPage, Integer pageSize);

    // 根据id查询答案
    @Caching(
            cacheable = {
                    @Cacheable(key = "'QuestionId='+#id+'--'+#currentPage+'--'+#pageSize")
            },
            put = {
                    @CachePut(key = "'QuestionId='+#id+'--'+#currentPage+'--'+#pageSize")

            })
    @Select("SELECT * FROM answer WHERE Question_id=#{id}")
    public List<answer> getAnswerSelectById(Integer id, Integer currentPage, Integer pageSize);

    // 根据id查题目、错误答案和正确答案，因为答案字段id不是主键，放弃该方法
//    @Cacheable(key = "'QuestionAnswerById='+#id+'--'+#currentPage+'--'+#pageSize", unless = "#result == null")
//    @Select("SELECT * FROM answer AS a,question_bank AS qb WHERE a.Question_id=qb.id AND qb.id=#{id}")
//    public questionAndAnswer getQuestionAnswerById(Integer id, Integer currentPage, Integer pageSize);

    // 根据id更新错误答案
    @Transactional
    @Update("UPDATE answer SET Error_Content=#{errorContent} WHERE Question_id=#{id}")
    public Integer updateErrorAnswerByIdAndString(Integer id, String errorContent, Integer currentPage, Integer pageSize);

    // 增加新的答案
    @Transactional
    @Insert("INSERT DELAYED INTO answer (Question_id,Error_Content,Correct_Content) VALUES (#{id},#{ErrorContent},#{CorrectContent})")
    public Integer insertErrorAnswerByIdAndString(Integer id, String ErrorContent, String CorrectContent);

    // 根据id删除答案
    @Transactional
    @Caching(
            evict = {
                    @CacheEvict(key = "'QuestionId='+#id+'--'+#currentPage+'--'+#pageSize")

            })
    @Delete("DELETE FROM answer WHERE Question_id=#{id}")
    public Integer deleteErrorAnswerById(Integer id, Integer currentPage, Integer pageSize);

    // 统计该id的错误答案条数
    @Select("SELECT count(*) FROM answer WHERE Question_id=#{id}")
    public Integer getAnswerCountById(Integer id);

}
