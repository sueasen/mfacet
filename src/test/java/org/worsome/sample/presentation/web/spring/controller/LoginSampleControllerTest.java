/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.presentation.web.spring.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.worsome.sample.business.domain.base.LoginSample;
import org.worsome.sample.business.service.LoginSampleService;
import org.worsome.sample.presentation.base.dto.LoginDto;
import org.worsome.sample.presentation.base.dto.LoginSampleDto;

/**
 * LoginSampleControllerTest
 *
 * @author SUEHARAA1
 */
public class LoginSampleControllerTest {

    /**
     * {@link LoginSampleController#LoginTestController(LoginSampleService)} のためのテスト・メソッド。
     */
    @Test
    public void testLoginSampleController() {
        assertNotNull(new LoginSampleController(mock(LoginSampleService.class)));
    }

    /**
     * {@link LoginSampleController#entryLoginForm(Model)} のためのテスト・メソッド。
     */
    @Test
    public void testEntryLoginForm() {
        Model model = mock(Model.class);

        String actual = new LoginSampleController(null).entryLoginForm(model);
        assertThat(actual, is("/sample/loginsample"));
        verify(model).addAttribute(eq("loginDto"), any(LoginDto.class));
    }

    /**
     * {@link LoginSampleController#login(LoginDto, BindingResult, Model)} のためのテスト・メソッド。<br>
     * ログイン成功時にログイン一覧にリダイレクトすることをの確認します。
     */
    @Test
    public void testLogin() {
        LoginSampleService service = mock(LoginSampleService.class);
        LoginDto dto = spy(new LoginDto());
        BindingResult result = mock(BindingResult.class);
        Model model = mock(Model.class);

        when(result.hasErrors()).thenReturn(false);
        dto.setId("test");
        dto.setPassword("pass");
        when(service.login(dto.getId(), dto.getPassword())).thenReturn(new LoginSample());

        String actual = new LoginSampleController(service).login(dto, result, model);
        assertThat(actual, is("redirect:/sample/loginSampleList"));
        verify(result, never()).addError(any(ObjectError.class));
        verify(service).login(dto.getId(), dto.getPassword());
    }

    /**
     * {@link LoginSampleController#login(LoginDto, BindingResult, Model)} のためのテスト・メソッド。<br>
     * 入力エラー時にログインに戻る事を確認します
     */
    @Test
    public void testLoginModelHasError() {
        LoginSampleService service = mock(LoginSampleService.class);
        LoginDto dto = spy(new LoginDto());
        BindingResult result = mock(BindingResult.class);
        Model model = mock(Model.class);

        when(result.hasErrors()).thenReturn(true);

        String actual = new LoginSampleController(service).login(dto, result, model);
        assertThat(actual, is("/sample/loginsample"));
        verify(result, never()).addError(any(ObjectError.class));
        verify(service, never()).login(anyString(), anyString());
    }

    /**
     * {@link LoginSampleController#login(LoginDto, BindingResult, Model)} のためのテスト・メソッド。<br>
     * ログインサンプルが存在しない場合、model にエラーを設定してログインに戻る事を確認します。
     */
    @Test
    public void testLoginEmptyEntity() {
        LoginSampleService service = mock(LoginSampleService.class);
        LoginDto dto = spy(new LoginDto());
        BindingResult result = mock(BindingResult.class);
        Model model = mock(Model.class);

        when(result.hasErrors()).thenReturn(false);
        dto.setId("test");
        dto.setPassword("pass");
        when(service.login(anyString(), anyString())).thenReturn(null);

        String actual = new LoginSampleController(service).login(dto, result, model);
        assertThat(actual, is("/sample/loginsample"));
        verify(result).addError(any(ObjectError.class));
        verify(service).login(anyString(), anyString());
        verify(dto).getId();
        verify(dto).getPassword();
    }

    /**
     * {@link LoginSampleController#findAll(Model)} のためのテスト・メソッド。
     */
    @Test
    public void testFindAll() {
        LoginSampleService service = mock(LoginSampleService.class);
        Model model = mock(Model.class);
        List<LoginSample> loginSamples = new ArrayList<>();

        when(service.findAll()).thenReturn(loginSamples);

        String actual = new LoginSampleController(service).findAll(model);
        assertThat(actual, is("/sample/loginSample/loginSampleList"));
        verify(model).addAttribute("loginSamples", loginSamples);
        verify(service).findAll();
    }

    /**
     * {@link LoginSampleController#entryLoginUserFormById(String, Model)} のためのテスト・メソッド。
     * ログインサンプルが存在の場合、Model にログインサンプルDTO が設定される事を確認します。
     */
    @Test
    public void testEntryLoginUserFormById() {
        LoginSampleService service = mock(LoginSampleService.class);
        Model model = mock(Model.class);
        String id = "test";
        LoginSample loginSample = spy(new LoginSample());

        when(service.find(id)).thenReturn(loginSample);

        String actual = new LoginSampleController(service).entryLoginUserFormById(id, model);
        assertThat(actual, is("/sample/loginSample/loginSampleEdit"));
        verify(model).addAttribute(eq("loginSampleDto"), any(LoginSampleDto.class));
        verify(service).find(anyString());
        verify(loginSample).getId();
        verify(loginSample).getPassword();
        verify(loginSample).getVersion();
    }

    /**
     * {@link LoginSampleController#entryLoginUserFormById(String, Model)} のためのテスト・メソッド。
     * ログインサンプルが存在無の場合、Model にログインサンプルDTO が設定される事を確認します。
     */
    @Test
    public void testEntryLoginUserFormByIdEmptyEntity() {
        LoginSampleService service = mock(LoginSampleService.class);
        Model model = mock(Model.class);
        String id = "test";
        when(service.find(id)).thenReturn(null);

        String actual = new LoginSampleController(service).entryLoginUserFormById(id, model);
        assertThat(actual, is("/sample/loginSample/loginSampleEdit"));
        verify(model).addAttribute(eq("loginSampleDto"), any(LoginSampleDto.class));
    }

    /**
     * {@link LoginSampleController#update(LoginSampleDto, BindingResult, Model)} のためのテスト・メソッド。
     * 更新を実行する場合の確認をします。
     */
    @Test
    public void testUpdate() {
        LoginSampleService service = mock(LoginSampleService.class);
        LoginSampleDto dto = spy(new LoginSampleDto());
        BindingResult result = mock(BindingResult.class);
        Model model = mock(Model.class);

        when(result.hasErrors()).thenReturn(false);
        doNothing().when(service).update(dto);

        String actual = new LoginSampleController(service).update(dto, result, model);
        assertThat(actual, is("redirect:/sample/loginSampleList"));
        verify(service).update(dto);
    }

    /**
     * {@link LoginSampleController#update(LoginSampleDto, BindingResult, Model)} のためのテスト・メソッド。
     * 入力エラー時に更新新しないことを確認をします。
     */
    @Test
    public void testUpdateHasError() {
        LoginSampleService service = mock(LoginSampleService.class);
        LoginSampleDto dto = spy(new LoginSampleDto());
        BindingResult result = mock(BindingResult.class);
        Model model = mock(Model.class);

        when(result.hasErrors()).thenReturn(true);

        String actual = new LoginSampleController(service).update(dto, result, model);
        assertThat(actual, is("/sample/loginSample/loginSampleEdit"));
        verify(service, never()).update(any(LoginSampleDto.class));
    }

    /**
     * {@link LoginSampleController#delete(LoginSampleDto, BindingResult, Model)} のためのテスト・メソッド。
     */
    @Test
    public void testDelete() {
        LoginSampleService service = mock(LoginSampleService.class);
        LoginSampleDto dto = spy(new LoginSampleDto());
        BindingResult result = mock(BindingResult.class);
        Model model = mock(Model.class);

        doNothing().when(service).delete(dto);

        String actual = new LoginSampleController(service).delete(dto, result, model);
        assertThat(actual, is("redirect:/sample/loginSampleList"));
        verify(service).delete(dto);
    }

    /**
     * {@link LoginSampleController#entryLoginUserForm(Model)} のためのテスト・メソッド。
     */
    @Test
    public void testEntryLoginUserForm() {
        Model model = mock(Model.class);

        when(model.addAttribute(eq("loginSampleDto"), any(LoginSampleDto.class))).thenReturn(model);

        String actual = new LoginSampleController(null).entryLoginUserForm(model);
        assertThat(actual, is("/sample/loginSample/loginSampleInsert"));
        verify(model).addAttribute(eq("loginSampleDto"), any(LoginSampleDto.class));
    }

    /**
     * {@link LoginSampleController#insert(LoginSampleDto, BindingResult, Model)} のためのテスト・メソッド。<br>
     * 追加実行時を確認します。
     */
    @Test
    public void testInsert() {

        LoginSampleService service = mock(LoginSampleService.class);
        LoginSampleDto dto = spy(new LoginSampleDto());
        BindingResult result = mock(BindingResult.class);
        Model model = mock(Model.class);

        when(result.hasErrors()).thenReturn(false);
        doNothing().when(service).insert(dto);

        String actual = new LoginSampleController(service).insert(dto, result, model);
        assertThat(actual, is("redirect:/sample/loginsample"));
        verify(service).insert(dto);
    }

    /**
     * {@link LoginSampleController#insert(LoginSampleDto, BindingResult, Model)} のためのテスト・メソッド。<br>
     * 入力エラー時に追加実行しないことを確認します。
     */
    @Test
    public void testInsertHasError() {

        LoginSampleService service = mock(LoginSampleService.class);
        LoginSampleDto dto = spy(new LoginSampleDto());
        BindingResult result = mock(BindingResult.class);
        Model model = mock(Model.class);

        when(result.hasErrors()).thenReturn(true);

        String actual = new LoginSampleController(service).insert(dto, result, model);
        assertThat(actual, is("/sample/loginSample/loginSampleInsert"));
        verify(service, never()).insert(dto);
    }
}
