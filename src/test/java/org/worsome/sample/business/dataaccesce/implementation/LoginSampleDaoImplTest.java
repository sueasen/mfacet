/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.business.dataaccesce.implementation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.worsome.sample.business.domain.base.LoginSample;

/**
 * LoginSampleDaoImplTest
 *
 * @author SUEHARAA1
 */
public class LoginSampleDaoImplTest {

    /**
     * {@link LoginSampleDaoImpl#loginSampleDaoImpl()} のためのテスト・メソッド。<br>
     * {@link LoginSampleDaoImpl#loginSampleDaoImpl(EntityManager)} のためのテスト・メソッド。
     */
    @Test
    public void testLoginSampleServiceImpl() {
        assertNotNull(new LoginSampleDaoImpl());
        assertNotNull(new LoginSampleDaoImpl(mock(EntityManager.class)));
    }

    /**
     * {@link LoginSampleDaoImpl#find(String)} のためのテスト・メソッド。
     */
    @Test
    public void testFindString() {

        String id = "test";
        LoginSample loginSample = new LoginSample();

        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(LoginSample.class, id)).thenReturn(loginSample);

        LoginSample result = new LoginSampleDaoImpl(entityManager).find(id);
        assertThat(result, is(loginSample));
        verify(entityManager, times(1)).find(LoginSample.class, id);
    }

    /**
     * {@link LoginSampleDaoImpl#find(String, String)} のためのテスト・メソッド。<br>
     * id, password が一致する testLogin が存在する場合、取得できることを確認します。
     */
    @Test
    public void testFindStringString() {
        String id = "test";
        String passsword = "passsword";
        LoginSample loginSample = spy(new LoginSample());

        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(LoginSample.class, id)).thenReturn(loginSample);
        loginSample.setPassword(passsword);

        LoginSample result = new LoginSampleDaoImpl(entityManager).find(id, passsword);
        assertThat(result, is(loginSample));
        verify(entityManager, times(1)).find(LoginSample.class, id);
        verify(loginSample, times(1)).getPassword();
    }

    /**
     * {@link LoginSampleDaoImpl#find(String, String)} のためのテスト・メソッド。<br>
     * id が一致する testLogin が存在しない場合、null になる事を確認します。
     */
    @Test
    public void testFindStringStringEmptyEntity() {
        String id = "test";
        String passsword = "passsword";

        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(LoginSample.class, id)).thenReturn(null);

        LoginSample result = new LoginSampleDaoImpl(entityManager).find(id, passsword);
        assertNull(result);
        verify(entityManager, times(1)).find(LoginSample.class, id);
    }

    /**
     * {@link LoginSampleDaoImpl#find(String, String)} のためのテスト・メソッド。<br>
     * password が一致する testLogin が存在しない場合、null になる事を確認します。
     */
    @Test
    public void testFindStringStringNotEqualsPassword() {
        String id = "test";
        String passsword = "passsword";
        LoginSample loginSample = spy(new LoginSample());

        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(LoginSample.class, id)).thenReturn(loginSample);
        loginSample.setPassword(id);

        LoginSample result = new LoginSampleDaoImpl(entityManager).find(id, passsword);
        assertNull(result);
        verify(entityManager, times(1)).find(LoginSample.class, id);
        verify(loginSample, times(1)).getPassword();
    }

    /**
     * {@link LoginSampleDaoImpl#findByVersion(String, Date)} のためのテスト・メソッド。<br>
     * id, version が一致する loginSample が存在する場合、取得できることをテストします。
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void testFindByVersion() {

        String id = "test";
        Date version = new Date();
        LoginSample loginSample = spy(new LoginSample());

        EntityManager entityManager = mock(EntityManager.class);
        CriteriaBuilder builder = mock(CriteriaBuilder.class);
        CriteriaQuery<LoginSample> query = mock(CriteriaQuery.class);
        Root<LoginSample> root = mock(Root.class);
        Path path = mock(Path.class);
        Predicate predicate = mock(Predicate.class);
        TypedQuery<LoginSample> typedQuery = mock(TypedQuery.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(builder);
        when(builder.createQuery(LoginSample.class)).thenReturn(query);
        when(query.from(LoginSample.class)).thenReturn(root);
        when(root.get("version")).thenReturn(mock(Path.class));
        when(builder.equal(path, version)).thenReturn(predicate);
        when(query.where(predicate)).thenReturn(query);
        when(entityManager.createQuery(query)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Arrays.asList(loginSample));

        LoginSample result = new LoginSampleDaoImpl(entityManager).findByVersion(id, version);
        assertThat(result, is(loginSample));
    }

    /**
     * {@link LoginSampleDaoImpl#findByVersion(String, Date)} のためのテスト・メソッド。<br>
     * id, version が一致する loginSample が存在しない場合、null になることをテストします。
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void testFindByVersionEmpty() {

        String id = "test";
        Date version = new Date();

        EntityManager entityManager = mock(EntityManager.class);
        CriteriaBuilder builder = mock(CriteriaBuilder.class);
        CriteriaQuery<LoginSample> query = mock(CriteriaQuery.class);
        Root<LoginSample> root = mock(Root.class);
        Path path = mock(Path.class);
        Predicate predicate = mock(Predicate.class);
        TypedQuery<LoginSample> typedQuery = mock(TypedQuery.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(builder);
        when(builder.createQuery(LoginSample.class)).thenReturn(query);
        when(query.from(LoginSample.class)).thenReturn(root);
        when(root.get("version")).thenReturn(mock(Path.class));
        when(builder.equal(path, version)).thenReturn(predicate);
        when(query.where(predicate)).thenReturn(query);
        when(entityManager.createQuery(query)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.emptyList());

        LoginSample result = new LoginSampleDaoImpl(entityManager).findByVersion(id, version);
        assertNull(result);
    }

    /**
     * {@link LoginSampleDaoImpl#findAll()} のためのテスト・メソッド。
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testFindAll() {
        List<LoginSample> loginSamples = new ArrayList<>();

        EntityManager entityManager = mock(EntityManager.class);
        CriteriaBuilder builder = mock(CriteriaBuilder.class);
        CriteriaQuery<LoginSample> query = mock(CriteriaQuery.class);
        TypedQuery<LoginSample> typedQuery = mock(TypedQuery.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(builder);
        when(builder.createQuery(LoginSample.class)).thenReturn(query);
        when(query.from(LoginSample.class)).thenReturn(mock(Root.class));
        when(query.select(any(Root.class))).thenReturn(query);
        when(entityManager.createQuery(query)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(loginSamples);

        List<LoginSample> results = new LoginSampleDaoImpl(entityManager).findAll();
        assertThat(results, is(loginSamples));
    }

    /**
     * {@link LoginSampleDaoImpl#update(LoginSample)} のためのテスト・メソッド。
     */
    @Test
    public void testUpdate() {
        LoginSample loginSample = new LoginSample();

        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.merge(loginSample)).thenReturn(loginSample);

        new LoginSampleDaoImpl(entityManager).update(loginSample);
        verify(entityManager, times(1)).merge(loginSample);
    }

    /**
     * {@link LoginSampleDaoImpl#insert(LoginSample)} のためのテスト・メソッド。
     */
    @Test
    public void testInsert() {
        LoginSample loginSample = new LoginSample();

        EntityManager entityManager = mock(EntityManager.class);
        doNothing().when(entityManager).persist(loginSample);

        new LoginSampleDaoImpl(entityManager).insert(loginSample);
        verify(entityManager, times(1)).persist(loginSample);
    }

    /**
     * {@link LoginSampleDaoImpl#delete(LoginSample)} のためのテスト・メソッド。
     */
    @Test
    public void testDelete() {
        LoginSample loginSample = new LoginSample();

        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.merge(loginSample)).thenReturn(loginSample);
        doNothing().when(entityManager).remove(loginSample);

        new LoginSampleDaoImpl(entityManager).delete(loginSample);
        verify(entityManager, times(1)).merge(loginSample);
        verify(entityManager, times(1)).remove(loginSample);
    }

}
