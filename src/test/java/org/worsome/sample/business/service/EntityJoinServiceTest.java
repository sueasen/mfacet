/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.business.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.worsome.mfacet.ContextLoadTest;
import org.worsome.mfacet.DBUnitSupport;
import org.worsome.sample.business.domain.base.Main;
import org.worsome.sample.business.domain.base.ManyA;
import org.worsome.sample.business.domain.base.ManyB;
import org.worsome.sample.business.domain.base.SubA;
import org.worsome.sample.business.domain.base.SubB;

/**
 * {@link EntityJoinServiceImplTest}
 *
 * @author SUEHARAA1
 */
public class EntityJoinServiceTest {

    /** SETUP_DATA */
    private static final String SETUP_DATA = "Setup_EntityJoinService.xml";

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
        beanFactory = ContextLoadTest.getBeanFactory();
        dbUnitSupport = new DBUnitSupport(beanFactory, EntityJoinService.class);
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
     * {@link EntityJoinServiceImpl#find()} のためのテスト・メソッド。
     *
     * @throws Exception 例外
     */
    @Test
    public void testFind() throws Exception {

        dbUnitSupport.cleanInsertData(SETUP_DATA);
        EntityJoinService service = beanFactory.getBean(EntityJoinService.class);

        List<?> list = service.find();

        // OneToOne : Main - SubA
        assertThat(((Main) list.get(0)).getSubA().getId(), is(11));
        assertThat(((SubA) list.get(1)).getMain().getId(), is(1));
        // OneToMany : Main - SubB
        assertThat(((Main) list.get(0)).getSubBs().size(), is(2));
        assertThat(((SubB) list.get(2)).getMain().getId(), is(1));
        // ManyToMany : ManyA - ManyB
        assertThat(((ManyA) list.get(3)).getManyBs().size(), is(2));
        assertThat(((ManyB) list.get(4)).getManyAs().size(), is(1));
    }

}
