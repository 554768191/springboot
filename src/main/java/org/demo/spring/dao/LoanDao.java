package org.demo.spring.dao;

import org.demo.spring.model.Loan;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public interface LoanDao {
    Long saveLoan(Loan loan);
    String getLoanById(String id);
    List<Loan> queryLoans(String loanName);
}
