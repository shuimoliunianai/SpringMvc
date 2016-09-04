package bean;

import org.apache.log4j.Logger;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by apple on 16/8/22.
 */
public class InjectCollectionsTest {
    private static final Logger LOGGER = Logger.getLogger(InjectCollectionsTest.class);
    @org.junit.Test
    public void testToString() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        InjectCollections injectCollections = (InjectCollections)context.getBean("injectCollections");
        LOGGER.debug(injectCollections);
    }
}