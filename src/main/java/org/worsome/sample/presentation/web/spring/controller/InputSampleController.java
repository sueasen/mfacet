/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.presentation.web.spring.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.worsome.sample.presentation.base.dto.InputDto;

/**
 * {@link InputSampleController}
 *
 * @author SUEHARAA1
 */
@Controller
public class InputSampleController {

    /**
     * コンストラクタ
     */
    public InputSampleController() {
    }

    /**
     * 入力フォームを設定します。<br>
     *
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/inputsample", method = GET)
    public String entryInputForm(Model model) {
        setInputItem(model);
        model.addAttribute("inputDto", new InputDto());
        model.addAttribute("checkBoxItems", Arrays.asList("check1", "check2", "check3"));
        return "/sample/inputsample";
    }

    /**
     * ログインします。<br>
     *
     * @param inputDto loginDto
     * @param result result
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/inputsample", method = POST)
    public String login(@Valid InputDto inputDto, BindingResult result, Model model) {
        setInputItem(model);
        if (result.hasErrors()) {
            return "/sample/inputsample";
        }
        return "/sample/inputsample";
    }

    /**
     * 入力アイテムを設定します。<br>
     *
     * @param model model
     */
    private static void setInputItem(Model model) {
        model.addAttribute("checkBoxItems", Arrays.asList("check1", "check2", "check3"));
        model.addAttribute("radiobuttonItems", Arrays.asList("radio1", "radio2", "radio3"));
        model.addAttribute("selectItems", Arrays.asList("select1", "select2", "select3"));
    }
}
