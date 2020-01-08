/**
 * 
 * @author Sam Glassco
 * @version 1.0
 */
public class Dog {

    private String name;
    private int age;

    public Dog() {
    name = "null";
    age = 0;
    }// end empty-argument constructor


    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }//end preferred constructor

    public String bark() {
        return "Bark, bark, bark!!!";
    }//end bark

    //Getters/Setters/ToString
    public String getName() {
        return name;
    }//end getName

    public void setName(String name) {
        this.name = name;
    }//end setname

    public int getAge() {
        return age;
    }//end getage

    public void setAge(int age) {
        this.age = age;
    }//end setage

    @Override
    public String toString() {
        return "Dog [name=" + name + ", age=" + age + "]";
    }//end toString



}//end class