package bean;

import org.apache.log4j.Logger;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by apple on 16/8/22.
 */
public class ExampleBeanTest {
    private final static Logger LOGGER = Logger.getLogger(ExampleBeanTest.class);

    @org.junit.Test
    public void testToString() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
        LOGGER.debug(exampleBean);
    }
}