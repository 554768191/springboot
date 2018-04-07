package org.demo.spring.restController;

import org.demo.spring.model.Loan;
import org.demo.spring.service.LendService;
import org.demo.spring.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Administrator on 2017/5/13 0013.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private LoanService loanService;
    @Autowired
    private LendService lendService;

    @RequestMapping(value = "/restControl/addLoan", method = RequestMethod.POST)
    public String addLoan(@RequestBody Loan loan) {
        loanService.saveLoan(loan);
        return "success";
    }

}