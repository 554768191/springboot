package org.demo.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.demo.spring.model.Lend;
import org.springframework.stereotype.Component;
/**
 * Created by Administrator on 2017/6/28 0028.
 */
@Mapper
@Component
public interface LendRecordDao {
    Long saveLend(Lend lendd);
    String getLendRecordById(String id);
}
