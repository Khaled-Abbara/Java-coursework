public class Main {
    
}


enum Message {
    SUCCESS,
    INDEX_OUT_OF_BOUNDS;
}

class Student {
    private int id;
    private String name;
    private int[] enrolledCourses = new int[4];

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        
    }
    
    // getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Message setCourse(int index, int courseCode) {
        if (index < 0 || index > 4) return Message.INDEX_OUT_OF_BOUNDS;
    
        enrolledCourses[index] = courseCode;
        return Message.SUCCESS;
    }
}

class Course {
    private int code;
    private String name;
    private Student[] students;

    public Course(int code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.students = new Student[capacity];
    }

    public int getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return students.length;
    }
}

class CourseManagement {
    private static 

}