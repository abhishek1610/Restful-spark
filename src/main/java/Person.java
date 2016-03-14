import java.io.Serializable;

public  class Person implements Serializable {

    //id:Int, ,name:String, surname:String,age:Int ,company:String,dept:String )

    private int id;
    private int payrolelid;
    private String name;
    private String surname;
    private int age;
    private String company;
    private String dept;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPayroleid() {
        return payrolelid;
    }

    public void setPayroleid(int payrolelid) {
        this.payrolelid = payrolelid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String name) {
        this.surname = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}