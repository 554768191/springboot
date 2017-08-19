package org.demo.spring.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demo.spring.model.Loan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
@Mapper
@Component
public interface LoanDao {
    Long saveLoan(Loan loan);
    String getLoanById(String id);
    List<Loan> queryLoans(@Param("loanName") String loanName, @Param("loanPersonId") String loanPersonId);
}
