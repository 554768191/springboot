package org.demo.spring.service.impl;

import org.demo.spring.dao.LoanDao;
import org.demo.spring.model.Loan;
import org.demo.spring.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanDao loanDao;
    @Override
    public Long saveLoan(Loan loan) {
        return loanDao.saveLoan(loan);
    }

    @Override
    public List<Loan> queryLoans(String loanName) {

        return loanDao.queryLoans(loanName);
    }

    @Override
    public String getLoanById(String id) {
        return loanDao.getLoanById(id);
    }
}
