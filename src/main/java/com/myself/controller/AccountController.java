package com.myself.controller;

import com.myself.domain.Account;
import com.myself.service.AccountService;
import com.myself.utils.ExcelParse;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping("/testUploadExcel")
    public String testUploadExcel(MultipartFile file) {
        ExcelParse excelParse = new ExcelParse();
        try {
            excelParse.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
            return "操作失败";
        }
        return "操作成功";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(Model model) {
        System.out.println("访问到了");
        System.out.println("account");
//        List<Account> list = accountService.findAll();
//        model.addAttribute("list", list);
        return "访问到了";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "add";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        accountService.saveAccount(account);
        return "redirect:findAll";
    }

    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(Model model, Integer id) {
        Account account = accountService.findById(id);
        model.addAttribute("account", account);
        return "update";
    }


    @RequestMapping("/updateAccount")
    public String updateAccount(Account account) {
        accountService.updateAccount(account);
        return "redirect:findAll";
    }

    @RequestMapping("/getParam")
    @ResponseBody
    public String getParam(HttpServletRequest request) {
        String queryString = request.getQueryString();
        System.out.println(queryString);
        return "请求到了";
    }


    public static void main(String[] args) {
        String s = "MMM       =           {'k1':'025','k2':'025','k3':'','k4':'T4','k5':'299666736812','k6':'','k7':'dff59ad2'}";
        s = s.replace(" ", "");
        s = s.substring(4);
        System.out.println(s);
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        jsonObject.put("k1","11111111");
//        String parse = (String)JSONObject.parse(s);
//        System.out.println(parse);
//        System.out.println("MMM="+jsonObject.toString());
        System.out.println(111);
    }

}
