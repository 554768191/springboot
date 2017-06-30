package org.demo.spring.service;

import org.apache.ibatis.annotations.Mapper;
import org.demo.spring.model.Loan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Mapper
@Component
public interface LoanService {
    Long saveLoan(Loan loan);
    List<Loan> queryLoans(String loanName);
    String getLoanById(String id);
}
