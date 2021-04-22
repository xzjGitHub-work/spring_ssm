package com.test.analyer;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;

import java.util.List;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/4/21 10:02
 */
public class AnsjTestDemo {
    @Test
    public void wordTest2333() {
        String str = "许兆举在国家电网电子科技部门工作，王八蛋不在";
        Result result = ToAnalysis.parse(str);
        List<Term> termList = result.getTerms();
        for (Term term : termList) {
            System.out.println(term.getName() + ":" + term.getNatureStr());
        }
    }
}
