package springCore;

/**
 * Created by apple on 16/8/21.
 */
public class Human {
    private Car car;

    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }

    public void myCarRun()
    {
        car.run();
    }
}
