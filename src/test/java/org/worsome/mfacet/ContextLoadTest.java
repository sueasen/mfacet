/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.mfacet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ContextLoadTest}
 *
 * @author SUEHARAA1
 */
public class ContextLoadTest {

    /**
     * xml ファイルの読込をテストします
     */
    @SuppressWarnings({ "resource", "unused" })
    @Test
    public void testXmlLoad() {
        ApplicationContext context = new ClassPathXmlApplicationContext(//
                "/META-INF/spring/beans-business.xml", //
                "/META-INF/spring/beans-webmvc.xml");
    }

}
