/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.presentation.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * {@link IndexController}
 *
 * @author SUEHARAA1
 */
@Controller
public class IndexController {

    /**
     * コンストラクタ
     */
    public IndexController() {
    }

    /**
     * @return 処理
     */
    @RequestMapping("/sample/index")
    public String hello() {
        return "/sample/index2";
    }

}
