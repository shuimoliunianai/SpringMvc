package Spring;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 16/8/21.
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    private final static Logger LOGGER = Logger.getLogger(ClassPathXmlApplicationContext.class);
    private Map<String, Object> beans = new HashMap<String, Object>();

    /**
     * @throws Exception
     */
    public ClassPathXmlApplicationContext() throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc = saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
        Element root = doc.getRootElement();
        List list = root.getChildren("bean");
        for (int i = 0; i < list.size(); i++) {
            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            Object object = Class.forName(clazz).newInstance();
            LOGGER.debug(id);
            LOGGER.debug(clazz);
            beans.put(id, object);
            for (Element propertyElement : (List<Element>) element.getChildren("property")) {
                String name = propertyElement.getAttributeValue("name");
                String beanInstance = propertyElement.getAttributeValue("bean");
                Object beanObject = beans.get(beanInstance);
                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                LOGGER.debug("method name = " + methodName);
                Method method = object.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
                method.invoke(object, beanObject);
            }
        }
    }

    public Object getBean(String id)
    {
        return beans.get(id);
    }

}
