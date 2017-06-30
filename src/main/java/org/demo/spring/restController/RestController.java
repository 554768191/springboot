package org.demo.spring.restController;

import org.demo.spring.model.Lend;
import org.demo.spring.model.Loan;
import org.demo.spring.model.User;
import org.demo.spring.service.LendService;
import org.demo.spring.service.LoanService;
import org.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by Administrator on 2017/5/13 0013.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoanService loanService;
    @Autowired
    private LendService lendService;
    @RequestMapping(value = "/restControl/register", method = RequestMethod.POST)
    public String register(@RequestBody User user) {
        //user.setRegtime(TimeUtil.getCurrentTime());
        user.setRegtime(Long.toString(System.currentTimeMillis()));
        userService.saveUser(user);
        return "success";
    }
    @RequestMapping(value = "/restControl/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        if(userService.getPasswordByUserName(user.username).equals(user.getPassword())){
            return "0";
        }else{
            return "1";
        }
    }
    /*@20170628*/
    @RequestMapping(value = "/restControl/queryLoans", method = RequestMethod.POST)
    public List<Loan> queryLoans(String loanName) {
        return loanService.queryLoans(loanName);
    }

    /*@20170629*/
    @RequestMapping(value = "/restControl/queryLends", method = RequestMethod.POST)
    public List<Lend> queryLends(String lendName) {
        return lendService.queryLends(lendName);
    }
}
