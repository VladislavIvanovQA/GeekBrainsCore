package lesson5;

public class Person {
    private final String firstName;
    private final String secondName;
    private final String middleName;
    private final String position;
    private final String email;
    private final String number;
    private final Double salary;
    private final Integer age;

    public Person(String firstName, String secondName, String middleName,
                  String position, String email, String number, Double salary, Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(toString());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
