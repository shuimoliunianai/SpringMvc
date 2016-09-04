package bean;

/**
 * Created by apple on 16/8/15.
 */
public class AmericanImpl implements Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void Speak()
    {
        System.out.println("I'm American,My name is "+this.name+",I'm "+this.age+" years old");
    }
}
