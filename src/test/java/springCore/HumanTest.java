package springCore;

import Spring.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by apple on 16/8/21.
 */
public class HumanTest {
    @Test
    public void testHuman() throws Exception
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        Human human = (Human) context.getBean("human");
//        Car car = new BWMCar();
//        human.setCar(car);
        human.myCarRun();
    }
}