/**
 * Created by alin on 4/19/2016.
 */
public class Person {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String name;
    private String number;

    public Person(String n,String p){
        name =n;
        number = p;

    }
}
