package bean;

/**
 * Created by apple on 16/8/22.
 */
public abstract class AbstractLookuoDemo implements DemoBean {
    public abstract MyHelper getMyHelper();

    public MyHelper getHelper()
    {
        return getMyHelper();
    }

    public void someOperation()
    {
        getMyHelper().doSomethingHelpful();
    }
}
