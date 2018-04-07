package org.demo.spring.restController;

import org.demo.spring.core.CheckoutUtil;
import org.demo.spring.core.TimeUtil;
import org.demo.spring.model.Lend;
import org.demo.spring.model.Loan;
import org.demo.spring.model.User;
import org.demo.spring.service.LendService;
import org.demo.spring.service.LoanService;
import org.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        user.setRegtime(TimeUtil.getCurrentTime());
//        user.setRegtime(Long.toString(System.currentTimeMillis()));
        userService.saveUser(user);
        return "success";
    }

    @RequestMapping(value = "/restControl/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        User usertemp = userService.getUser(user.getUsername());
        if (null != usertemp) {
            /*已注册用户、调用登录逻辑*/
            if (userService.getPasswordByUserName(user.username).equals(user.getPassword())) {
                return "0";//验证成功！
            } else {
                return "1";//用户名或密码不正确！
            }
        } else {
            /*新用户、调用注册逻辑*/
            userService.saveUser(user);
            this.login(user);
        }
        return "0";//验证成功！
    }

    /*@20170628*/
    @RequestMapping(value = "/restControl/queryLoans", method = RequestMethod.POST)
    public List<Loan> queryLoans(String loanName, String loanPersonId) {
        return loanService.queryLoans(loanName, loanPersonId);
    }

    /*@20170629*/
    @RequestMapping(value = "/restControl/queryLends", method = RequestMethod.POST)
    public List<Lend> queryLends(String lendName) {
        return lendService.queryLends(lendName);
    }
    /*@20170629*/
    @RequestMapping(value = "/restControl/queryUsers", method = RequestMethod.GET)
    public List<User> queryUsers() {
        return userService.queryUsers();
    }

    /**
     * 微信消息接收和token验证
     *
     * @param model
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/restControl/tokenValidate")
    public void tokenValidate(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter print;
        if (isGet) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
                try {
                    print = response.getWriter();
                    print.write(echostr);
                    print.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}