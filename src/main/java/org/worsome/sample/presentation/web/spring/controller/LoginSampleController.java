/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.presentation.web.spring.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.worsome.sample.business.domain.base.LoginSample;
import org.worsome.sample.business.service.LoginSampleService;
import org.worsome.sample.presentation.base.dto.LoginDto;
import org.worsome.sample.presentation.base.dto.LoginSampleDto;

/**
 * {@link LoginSampleController}
 *
 * @author SUEHARAA1
 */
@Controller
public class LoginSampleController {

    /** loginTestService */
    private LoginSampleService loginSampleService;

    /**
     * コンストラクタ
     *
     * @param loginSampleService loginSampleService
     */
    @Autowired
    public LoginSampleController(LoginSampleService loginSampleService) {
        this.loginSampleService = loginSampleService;
    }

    /**
     * ログイン情報を model に設定します。
     *
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/loginsample", method = GET)
    public String entryLoginForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "/sample/loginsample";
    }

    /**
     * ログインします。<br>
     *
     * @param loginDto loginDto
     * @param result result
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/loginsample", method = POST)
    public String login(@Valid LoginDto loginDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sample/loginsample";
        }
        LoginSample loginSample = loginSampleService.login(loginDto.getId(), loginDto.getPassword());
        if (loginSample == null) {
            result.addError(new ObjectError("message", "login fail"));
            return "/sample/loginsample";
        }
        return "redirect:/sample/loginSampleList";
    }

    /**
     * ログインサンプル一覧を表示します。<br>
     *
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/loginSampleList", method = GET)
    public String findAll(Model model) {
        model.addAttribute("loginSamples", loginSampleService.findAll());
        return "/sample/loginSample/loginSampleList";
    }

    /**
     * ログインサンプルを検索して model に設定します。<br>
     *
     * @param id id
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/loginSample/{id}", method = GET)
    public String entryLoginUserFormById(@PathVariable String id, Model model) {
        LoginSample loginSample = loginSampleService.find(id);
        LoginSampleDto loginSampleDto = new LoginSampleDto();
        if (loginSample != null) {
            BeanUtils.copyProperties(loginSample, loginSampleDto);
        }
        model.addAttribute("loginSampleDto", loginSampleDto);
        return "/sample/loginSample/loginSampleEdit";
    }

    /**
     * ログインサンプルを更新します。<br>
     *
     * @param loginSampleDto loginSampleDto
     * @param result result
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/loginSampleEdit", method = POST, params = "update")
    public String update(@Valid LoginSampleDto loginSampleDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sample/loginSample/loginSampleEdit";
        }
        loginSampleService.update(loginSampleDto);
        return "redirect:/sample/loginSampleList";
    }

    /**
     * ログインサンプルを削除します。<br>
     *
     * @param loginSampleDto loginSampleDto
     * @param result result
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/loginSampleEdit", method = POST, params = "delete")
    public String delete(@Valid LoginSampleDto loginSampleDto, BindingResult result, Model model) {
        loginSampleService.delete(loginSampleDto);
        return "redirect:/sample/loginSampleList";
    }

    /**
     * ログインサンプルを model に設定します。<br>
     *
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/loginSampleInsert", method = GET)
    public String entryLoginUserForm(Model model) {
        model.addAttribute("loginSampleDto", new LoginSampleDto());
        return "/sample/loginSample/loginSampleInsert";
    }

    /**
     * ログインサンプルを登録します。<br>
     *
     * @param loginSampleDto loginSampleDto
     * @param result result
     * @param model model
     * @return 処理
     */
    @RequestMapping(value = "/sample/loginSampleInsert", method = POST, params = "insert")
    public String insert(@Valid LoginSampleDto loginSampleDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/sample/loginSample/loginSampleInsert";
        }
        loginSampleService.insert(loginSampleDto);
        return "redirect:/sample/loginsample";
    }

}