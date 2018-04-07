package org.demo.spring.service.impl;

import org.demo.spring.dao.LoanDao;
import org.demo.spring.model.Loan;
import org.demo.spring.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanDao loanDao;
    @Override
    public void saveLoan(Loan loan) {
        loanDao.saveLoan(loan);
    }

    @Override
    public List<Loan> queryLoans(String loanName,String loanPersonId) {

        return loanDao.queryLoans(loanName,loanPersonId);
    }

    @Override
    public String getLoanById(String id) {
        return loanDao.getLoanById(id);
    }
}
