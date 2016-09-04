package bean;

import org.apache.log4j.Logger;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by apple on 16/8/22.
 */
public class SimpleBeanTest {
    private final static Logger LOGGER = Logger.getLogger(SimpleBeanTest.class);
    @org.junit.Test
    public void SimpleTest()
    {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] a = {"读者"};
        String hello = context.getMessage("hello",a, Locale.getDefault());
        Object[] b = {new Date()};
        String now = context.getMessage("now",b,Locale.getDefault());
        LOGGER.info(hello);
        LOGGER.info(now);

        hello = context.getMessage("hello",a,Locale.US);
        now = context.getMessage("now",b,Locale.US);
        LOGGER.info(hello);
        LOGGER.info(now);

        hello = context.getMessage("hello",a,Locale.CHINA);
        now = context.getMessage("now",b,Locale.CHINA);
        LOGGER.info(hello);
        LOGGER.info(now);
        context.registerShutdownHook();
    }
}