package springCore;

import org.apache.log4j.Logger;

/**
 * Created by apple on 16/8/21.
 */
public class BWMCar implements Car {
    private String MyBrand = "宝马";
    private final static Logger LOGGER = Logger.getLogger(BWMCar.class);
    @Override
    public String getBrand()
    {
        return MyBrand;
    }
    @Override
    public void run()
    {
        LOGGER.debug(MyBrand + "is running");
    }
}
