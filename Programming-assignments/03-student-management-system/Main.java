public class Main {
    public static void Main(String[] args) {
        System.out.println("Hello World!");
    }

    static Student addStudent(int id, String name, int age, int grade) {
        return new Student(id, name, age, grade);
    }

    static void viewStudent(Student student) {
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getGrade());
    }

    static void updateStudent(Student student, String variable, String newValue) {
        if (variable.equalsIgnoreCase("name")) {
            student.setName(newValue);
        }

        if (variable.equalsIgnoreCase("age")) {
            student.setAge(Integer.parseInt(newValue));
        }

        if (variable.equalsIgnoreCase("grade")) {
            student.setGrade(Integer.parseInt(newValue));
        }

        System.out.println(0);
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private int grade;

    public Student(int id, String name, int age, int grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    // setters
    // (ID is a unique unchanged value so no setters)

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}

class StudentSystem {
    Student[] students;

    public StudentSystem(int capacity) {
        students = new Student[capacity];
    }

    public void viewAllStudents() {
        for (Student student : students) {
            System.out.println("");
        }
    }

}