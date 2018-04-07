package org.demo.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.demo.spring.model.Loan;
import org.springframework.stereotype.Component;
/**
 * Created by Administrator on 2017/6/28 0028.
 */
@Mapper
@Component
public interface LoanRecordDao {
    Long saveLoan(Loan loan);
    String getLoanRecordById(String id);
}
