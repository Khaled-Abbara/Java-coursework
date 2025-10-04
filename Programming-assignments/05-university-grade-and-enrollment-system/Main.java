public class Main {
    
}


enum Message {
    SUCCESS,
    INDEX_OUT_OF_BOUNDS;
}

class Student {
    private int id;
    private String name;
    private String[] enrolledCourses = new String[4];

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

    public String[] getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Message setCourse(int index, String courseName) {
        if (index < 0 || index > 4) return Message.INDEX_OUT_OF_BOUNDS;
    
        enrolledCourses[index] = courseName;
        return Message.SUCCESS;
    }
}

class Course {
    private int code;
    private String name;
    private int capacity;

    public Course(int code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
    }

    public int getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}

class CourseManagement {
    
    
}