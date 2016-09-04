package bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by apple on 16/8/22.
 */
public class SimpleBean implements InitializingBean,BeanNameAware{
    private static final Logger LOGGER = Logger.getLogger(SimpleBean.class);
    private static final String DEFAULT_NAME = "Mark";
    private static final int DEFAULT_AGE = 20;
    private int age = 0;
    private String name;
    private String beanName;

    public SimpleBean()
    {
        LOGGER.info("Spring 实例化 bean...");
    }

    public static String getDefaultName() {
        return DEFAULT_NAME;
    }

    public static int getDefaultAge() {
        return DEFAULT_AGE;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        LOGGER.info("Spring执行依赖关系注入...");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        LOGGER.info("Spring执行依赖关系注入...");
        this.name = name;
    }

    public void close()
    {
        LOGGER.info("调用close()..");
        LOGGER.info("此时可以用来执行销毁前的资源回收方法...");
    }

    public String toString()
    {
        return "name: "+name+"\n"+"age: "+ age + "\n"+"----------\n";
    }

    public void afterPropertiesSet() throws Exception{
        LOGGER.info(beanName+" 初始化,调用afterPropertiesSet()... ");
    }

    public void setBeanName(String beanName)
    {
        this.beanName = beanName;
        LOGGER.info("回调 setBeanName 方法 获得BeanName "+beanName);
    }
}
