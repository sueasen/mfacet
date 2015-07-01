/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.business.service.implementation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.worsome.sample.business.dataaccesce.LoginSampleDao;
import org.worsome.sample.business.domain.base.LoginSample;
import org.worsome.sample.presentation.base.dto.LoginSampleDto;

/**
 * LoginSampleServiceImplTest
 *
 * @author SUEHARAA1
 */
public class LoginSampleServiceImplTest {

    /**
     * {@link LoginSampleServiceImpl#LoginSampleServiceImpl(LoginSampleDao)} のためのテスト・メソッド。
     */
    @Test
    public void testLoginSampleServiceImpl() {
        assertNotNull(new LoginSampleServiceImpl(mock(LoginSampleDao.class)));
    }

    /**
     * {@link LoginSampleServiceImpl#login(String, String)} のためのテスト・メソッド。<br>
     * id, password がある場合、dao より loginSample を取得することを確認します。
     */
    @Test
    public void testLogin() {
        String id = "test";
        String password = "password";

        LoginSampleDao dao = mock(LoginSampleDao.class);
        when(dao.find(id, password)).thenReturn(new LoginSample());

        LoginSample result = new LoginSampleServiceImpl(dao).login(id, password);
        assertNotNull(result);
        verify(dao, times(1)).find(id, password);
    }

    /**
     * {@link LoginSampleServiceImpl#login(String, String)} のためのテスト・メソッド。<br>
     * id が空文字, null の場合、null を取得することを確認します。
     */
    @Test
    public void testLoginEmptyId() {

        String password = "password";

        LoginSampleDao dao = mock(LoginSampleDao.class);
        LoginSample result;

        result = new LoginSampleServiceImpl(dao).login("", password);
        assertNull(result);
        verify(dao, never()).find(anyString(), anyString());

        result = new LoginSampleServiceImpl(dao).login(null, password);
        assertNull(result);
        verify(dao, never()).find(anyString(), anyString());
    }

    /**
     * {@link LoginSampleServiceImpl#login(String, String)} のためのテスト・メソッド。<br>
     * password が空文字, null の場合、null を取得することを確認します。
     */
    @Test
    public void testLoginEmptyPassword() {

        String id = "test";

        LoginSampleDao dao = mock(LoginSampleDao.class);
        LoginSample result;

        result = new LoginSampleServiceImpl(dao).login(id, "");
        assertNull(result);
        verify(dao, never()).find(anyString(), anyString());

        result = new LoginSampleServiceImpl(dao).login(id, null);
        assertNull(result);
        verify(dao, never()).find(anyString(), anyString());
    }

    /**
     * {@link LoginSampleServiceImpl#find(String)} のためのテスト・メソッド。
     * id がある場合、dao より loginSample を取得することを確認します。
     */
    @Test
    public void testFind() {
        String id = "test";

        LoginSampleDao dao = mock(LoginSampleDao.class);
        when(dao.find(id)).thenReturn(new LoginSample());

        LoginSample result = new LoginSampleServiceImpl(dao).find(id);
        assertNotNull(result);
        verify(dao, times(1)).find(id);
    }

    /**
     * {@link LoginSampleServiceImpl#find(String)} のためのテスト・メソッド。
     * id が空文字, null の場合、null を取得することを確認します。
     */
    @Test
    public void testFindEmptyId() {

        LoginSampleDao dao = mock(LoginSampleDao.class);
        LoginSample result;

        result = new LoginSampleServiceImpl(dao).find("");
        assertNull(result);
        verify(dao, never()).find(anyString());

        result = new LoginSampleServiceImpl(dao).find(null);
        assertNull(result);
        verify(dao, never()).find(anyString());
    }

    /**
     * {@link LoginSampleServiceImpl#findAll()} のためのテスト・メソッド。
     */
    @Test
    public void testFindAll() {

        List<LoginSample> loginSamples = new ArrayList<>();

        LoginSampleDao dao = mock(LoginSampleDao.class);
        when(dao.findAll()).thenReturn(loginSamples);

        List<LoginSample> result = new LoginSampleServiceImpl(dao).findAll();

        assertThat(result, is(loginSamples));
        verify(dao, times(1)).findAll();
    }

    /**
     * {@link LoginSampleServiceImpl#update(LoginSampleDto)} のためのテスト・メソッド。<br>
     * 引数がある場合、update が実行されることを確認します。
     */
    @Test
    public void testUpdate() {
        LoginSampleDto dto = spy(new LoginSampleDto());

        LoginSampleDao dao = mock(LoginSampleDao.class);
        doNothing().when(dao).update(any(LoginSample.class));

        new LoginSampleServiceImpl(dao).update(dto);
        verify(dao, times(1)).update(any(LoginSample.class));
        verify(dto, times(1)).getId();
        verify(dto, times(1)).getPassword();
        verify(dto, times(1)).getVersion();
    }

    /**
     * {@link LoginSampleServiceImpl#update(LoginSampleDto)} のためのテスト・メソッド。
     * 引数がない場合、update が実行されないことを確認します。
     */
    @Test
    public void testUpdateEmptyArg() {

        LoginSampleDao dao = mock(LoginSampleDao.class);

        try {
            new LoginSampleServiceImpl(dao).update(null);
            fail();
        } catch (IllegalArgumentException e) {
            verify(dao, never()).update(any(LoginSample.class));
        }
    }

    /**
     * {@link LoginSampleServiceImpl#insert(LoginSampleDto)} のためのテスト・メソッド。
     * 引数がある場合、insert が実行されることを確認します。
     */
    @Test
    public void testInsert() {
        LoginSampleDto dto = spy(new LoginSampleDto());

        LoginSampleDao dao = mock(LoginSampleDao.class);
        doNothing().when(dao).insert(any(LoginSample.class));

        new LoginSampleServiceImpl(dao).insert(dto);
        verify(dao, times(1)).insert(any(LoginSample.class));
        verify(dto, times(1)).getId();
        verify(dto, times(1)).getPassword();
        verify(dto, times(1)).getVersion();
    }

    /**
     * {@link LoginSampleServiceImpl#insert(LoginSampleDto)} のためのテスト・メソッド。
     * 引数がない場合、insert が実行されないことを確認します。
     */
    @Test
    public void testInsertEmptyArg() {

        LoginSampleDao dao = mock(LoginSampleDao.class);

        try {
            new LoginSampleServiceImpl(dao).insert(null);
            fail();
        } catch (IllegalArgumentException e) {
            verify(dao, never()).insert(any(LoginSample.class));
        }
    }

    /**
     * {@link LoginSampleServiceImpl#delete(LoginSampleDto)} のためのテスト・メソッド。
     * 引数がある場合、delete が実行されることを確認します。
     */
    @Test
    public void testDelete() {
        LoginSampleDto dto = spy(new LoginSampleDto());

        LoginSampleDao dao = mock(LoginSampleDao.class);
        doNothing().when(dao).delete(any(LoginSample.class));

        new LoginSampleServiceImpl(dao).delete(dto);
        verify(dao, times(1)).delete(any(LoginSample.class));
        verify(dto, times(1)).getId();
        verify(dto, times(1)).getPassword();
        verify(dto, times(1)).getVersion();
    }

    /**
     * {@link LoginSampleServiceImpl#delete(LoginSampleDto)} のためのテスト・メソッド。
     * 引数がない場合、delete が実行されないことを確認します。
     */
    @Test
    public void testDeleteEmptyArg() {

        LoginSampleDao dao = mock(LoginSampleDao.class);
        doNothing().when(dao).delete(any(LoginSample.class));

        try {
            new LoginSampleServiceImpl(dao).delete(null);
            fail();
        } catch (IllegalArgumentException e) {
            verify(dao, never()).delete(any(LoginSample.class));
        }
    }

}
