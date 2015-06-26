/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.presentation.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * {@link HelloWorldController}
 *
 * @author SUEHARAA1
 */
@Controller
public class HelloWorldController {

    /**
     * コンストラクタ
     */
    public HelloWorldController() {
    }

    @RequestMapping("/sample/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "/sample/helloworld";
    }

}
