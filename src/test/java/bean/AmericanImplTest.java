package bean;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by apple on 16/8/15.
 */
public class AmericanImplTest {
    private ApplicationContext context;
    @org.junit.Before
    public void before()
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @org.junit.Test
    public void testSpeak() throws Exception {
        Person person = (Person) context.getBean("american");
        person.Speak();
    }
}