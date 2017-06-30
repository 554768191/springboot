package org.demo.spring.dao;

import org.demo.spring.model.Loan;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public interface LoanRecordDao {
    Long saveLoan(Loan loan);
    String getLoanRecordById(String id);
}
