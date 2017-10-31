package org.demo.spring.model;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class Loan {

    public Long id;
    public String loanCode;
    public String loanName;
    public String loanDesc;
    public String loanInterest;
    public int loanInterestType;
    public int loanPersonId;
    public String loanTime;
    public int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanDesc() {
        return loanDesc;
    }

    public void setLoanDesc(String loanDesc) {
        this.loanDesc = loanDesc;
    }

    public String getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(String loanInterest) {
        this.loanInterest = loanInterest;
    }

    public int getLoanInterestType() {
        return loanInterestType;
    }

    public void setLoanInterestType(int loanInterestType) {
        this.loanInterestType = loanInterestType;
    }

    public int getLoanPersonId() {
        return loanPersonId;
    }

    public void setLoanPersonId(int loanPersonId) {
        this.loanPersonId = loanPersonId;
    }

    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
