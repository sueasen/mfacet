/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.mfacet;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ContextLoadTest}
 *
 * @author SUEHARAA1
 */
public class ContextLoadTest {

    /** beanFactory */
    private static BeanFactory beanFactory;

    /**
     * xml ファイルの読込をテストします
     */
    @Test
    public void testXmlLoad() {
        getBeanFactory();
    }

    /**
     * beanFactory を取得します
     *
     * @return beanFactory
     */
    public static BeanFactory getBeanFactory() {
        if (beanFactory == null) {
            beanFactory = new ClassPathXmlApplicationContext(//
                    "/META-INF/spring/beans-business.xml", //
                    "/META-INF/spring/beans-webmvc.xml");
        }
        return beanFactory;
    }
}
