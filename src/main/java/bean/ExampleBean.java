package bean;

/**
 * Created by apple on 16/8/22.
 */
public class ExampleBean {
    private String name;
    private int age;
    private float height;
    private boolean isChinese;

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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isChinese() {
        return isChinese;
    }

    public void setChinese(boolean chinese) {
        isChinese = chinese;
    }

    public String toString()
    {
        return String.format("name: %s\n"+"age: %d\n"+"height :%g\n"+"isChinese: %b\n",name,age,height,isChinese);
    }
}
