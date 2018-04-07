package org.demo.spring.service;

import org.demo.spring.model.Loan;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public interface LoanService {
    void saveLoan(Loan loan);
    List<Loan> queryLoans(String loanName, String loanPersonId);
    String getLoanById(String id);
}
