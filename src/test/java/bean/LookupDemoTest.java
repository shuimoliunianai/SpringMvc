package bean;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.NOPLogger;
import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by apple on 16/8/22.
 */
public class LookupDemoTest {
    private final static Logger LOGGER = Logger.getLogger(LookupDemoTest.class);
    @org.junit.Test
    public void test() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        stressTest(context,"abstractLookuoDemo");
        LOGGER.info("-----------------------------");
        stressTest(context,"standardLookupDemo");
    }

    public static void stressTest(AbstractApplicationContext context,String beanName)
    {
        DemoBean bean = (DemoBean) context.getBean(beanName);
        MyHelper helper1 = bean.getHelper();
        MyHelper helper2 = bean.getHelper();
        LOGGER.info("测试 "+beanName);
        LOGGER.info("Helper 实例是否相同?:" + (helper1 == helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("luupupDemo");
        for (int i=0;i<10000;i++)
        {
            MyHelper helper = bean.getHelper();
            helper.doSomethingHelpful();
        }
        stopWatch.stop();
        LOGGER.info("获取10000次花费了 "+stopWatch.getTotalTimeMillis()+ " 毫秒");
    }
}
