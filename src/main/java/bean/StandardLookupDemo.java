package bean;

/**
 * Created by apple on 16/8/22.
 */
public class StandardLookupDemo implements DemoBean {
    private MyHelper myHelper;

    public MyHelper getMyHelper() {
        return myHelper;
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    public MyHelper getHelper()
    {
        return this.myHelper;
    }

    @Override
    public void someOperation()
    {
        myHelper.doSomethingHelpful();
    }
}
