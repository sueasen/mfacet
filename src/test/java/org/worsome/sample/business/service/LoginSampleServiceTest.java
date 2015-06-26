/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.business.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.worsome.mfacet.DBUnitSupport;
import org.worsome.sample.business.domain.base.LoginSample;
import org.worsome.sample.presentation.base.dto.LoginSampleDto;

/**
 * {@link LoginSampleService}
 *
 * @author SUEHARAA1
 */
public class LoginSampleServiceTest {

    /** SETUP_DATA */
    private static final String SETUP_DATA = "Setup_LoginSampleService.xml";

    /** beanFactory */
    private static BeanFactory beanFactory;

    /** dbUnitSupport */
    private static DBUnitSupport dbUnitSupport;

    /**
     * テストクラスの事前前処理です
     *
     * @throws Exception 例外
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        beanFactory = new ClassPathXmlApplicationContext("/META-INF/spring/beans-business.xml");
        dbUnitSupport = new DBUnitSupport(beanFactory, LoginSampleService.class);
    }

    /**
     * テストクラスの事後処理です。
     *
     * @throws Exception 例外
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * テストメソッドの事後処理です。
     *
     * @throws Exception 例外
     */
    @After
    public void tearDown() throws Exception {
        dbUnitSupport.deleteAllData(SETUP_DATA);
    }

    /**
     * {@link org.worsome.sample.business.service.LoginSampleService#login(java.lang.String, java.lang.String)} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testLogin() throws Exception {

        dbUnitSupport.cleanInsertData(SETUP_DATA);
        LoginSampleService service = beanFactory.getBean(LoginSampleService.class);

        LoginSample loginSample = service.login("test", "pass");

        assertThat(loginSample.getId(), is("test"));
        assertThat(loginSample.getPassword(), is("pass"));
    }

    /**
     * {@link org.worsome.sample.business.service.LoginSampleService#login(java.lang.String, java.lang.String)} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testLoginEmpty() throws Exception {

        dbUnitSupport.cleanInsertData(SETUP_DATA);
        LoginSampleService service = beanFactory.getBean(LoginSampleService.class);

        assertNull(service.login("Test", "pass"));
        assertNull(service.login("test", "pasS"));
    }

    /**
     * {@link org.worsome.sample.business.service.LoginSampleService#find(java.lang.String)} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testFind() throws Exception {

        dbUnitSupport.cleanInsertData(SETUP_DATA);
        LoginSampleService service = beanFactory.getBean(LoginSampleService.class);

        LoginSample loginSample = service.find("test1");

        assertThat(loginSample.getId(), is("test1"));
    }

    /**
     * {@link org.worsome.sample.business.service.LoginSampleService#find(java.lang.String)} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testFindEmpty() throws Exception {

        dbUnitSupport.cleanInsertData(SETUP_DATA);
        LoginSampleService service = beanFactory.getBean(LoginSampleService.class);

        assertNull(service.find("tesT"));
    }

    /**
     * {@link org.worsome.sample.business.service.LoginSampleService#findAll()} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testFindAll() throws Exception {

        dbUnitSupport.cleanInsertData(SETUP_DATA);
        LoginSampleService service = beanFactory.getBean(LoginSampleService.class);

        List<LoginSample> loginSamples = service.findAll();

        assertThat(loginSamples.size(), is(2));

        loginSamples.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));

        assertThat(loginSamples.get(0).getId(), is("test"));
        assertThat(loginSamples.get(1).getId(), is("test1"));
    }

    /**
     * {@link org.worsome.sample.business.service.LoginSampleService#update(org.worsome.sample.presentation.base.dto.LoginSampleDto)} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testUpdate() throws Exception {

        dbUnitSupport.cleanInsertData(SETUP_DATA);
        LoginSampleService service = beanFactory.getBean(LoginSampleService.class);

        LoginSampleDto dto = new LoginSampleDto();
        dto.setId("test");
        dto.setPassword("1111");
        dto.setVersion(DateUtils.parseDate("2000/01/01 01:01:01.000000", "yyyy/MM/dd HH:mm:ss.SSS"));

        service.update(dto);

        String tableName = "LOGIN_SAMPLE";
        String sortColum = "ID";
        ITable expectedTable = dbUnitSupport.getExpectedTable("Assert_LoginSampleService_update.xml", tableName,
                sortColum);
        ITable actualTable = dbUnitSupport.getActualTable(tableName, sortColum);

        Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, new String[] { "version" });
    }

    /**
     * {@link org.worsome.sample.business.service.LoginSampleService#insert(org.worsome.sample.presentation.base.dto.LoginSampleDto)} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testInsert() throws Exception {

        dbUnitSupport.deleteAllData(SETUP_DATA);
        LoginSampleService service = beanFactory.getBean(LoginSampleService.class);

        LoginSampleDto dto = new LoginSampleDto();
        dto.setId("add");
        dto.setPassword("1dd");

        service.insert(dto);

        IDataSet expectedDataSet = dbUnitSupport.getExpectedDataSet("Assert_LoginSampleService_insert.xml");
        IDataSet actualDataSet = dbUnitSupport.getActualDataSet();

        Assertion.assertEqualsIgnoreCols(expectedDataSet, actualDataSet, "LOGIN_SAMPLE", new String[] { "version" });
    }

    /**
     * {@link org.worsome.sample.business.service.LoginSampleService#delete(org.worsome.sample.presentation.base.dto.LoginSampleDto)} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testDelete() throws Exception {

        dbUnitSupport.cleanInsertData(SETUP_DATA);
        LoginSampleService service = beanFactory.getBean(LoginSampleService.class);

        LoginSampleDto dto = new LoginSampleDto();
        dto.setId("test");
        dto.setVersion(DateUtils.parseDate("2000/01/01 01:01:01.000000", "yyyy/MM/dd HH:mm:ss.SSS"));

        service.delete(dto);

        IDataSet expectedDataSet = dbUnitSupport.getExpectedDataSet("Assert_LoginSampleService_delete.xml");
        IDataSet actualDataSet = dbUnitSupport.getActualDataSet();

        Assertion.assertEqualsIgnoreCols(expectedDataSet, actualDataSet, "LOGIN_SAMPLE", new String[] { "version" });
    }

}
