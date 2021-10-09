package com.egs.controller;

import com.egs.exception.InsufficientBalanceException;
import com.egs.exception.InvalidAmountException;
import com.egs.service.IUserInfoService;
import com.egs.utils.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("app/account")
public class AccountController {
    @Autowired
    private IUserInfoService userInfoService;


    @RequestMapping(value = "/withdraw/{amt}", method = RequestMethod.GET)
    public ModelAndView withdraw(@PathVariable double amt) throws InsufficientBalanceException, InvalidAmountException {
        double balance = userInfoService.getAllBalances().getBalance();
        AccountValidator.validateAmount(amt);
        AccountValidator.validateRemainingBalance(amt, balance);
        userInfoService.withdraw(amt);
        return new ModelAndView(new RedirectView("/app/secure/account-details"));
    }

    @RequestMapping(value = "/deposit/{amt}", method = RequestMethod.GET)
    public ModelAndView deposit(@PathVariable double amt) throws InvalidAmountException {
        AccountValidator.validateAmount(amt);
            userInfoService.deposit(amt);
        return new ModelAndView(new RedirectView("/app/secure/account-details"));
    }

}
