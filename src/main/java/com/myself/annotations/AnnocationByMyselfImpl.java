package com.myself.annotations;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.config.plugins.validation.ConstraintValidator;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/3/16 18:22
 */
public class AnnocationByMyselfImpl  implements ConstraintValidator<AnnocationByMyself> {

    @Override
    public void initialize(AnnocationByMyself annotation) {
        System.out.println("initialize执行了");
    }

    @Override
    public boolean isValid(String name, Object value) {
        System.out.println(name);
        System.out.println(value);
        return false;
    }
}
