public class Main {
    
}


enum Message {
    SUCCESS,
    INDEX_OUT_OF_BOUNDS,
    ARRAY_IS_FULL,
    COURSE_ALREADY_EXISTS;
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
    private Student[] enrolledStudents;

    public Course(int code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.enrolledStudents = new Student[capacity];
    }

    public int getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return enrolledStudents.length;
    }
}

class CourseManagement {
    private static Student[] students = new Student[500];
    private static Course[] courses = new Course[5];

    static Message addCourse(int code, String name, int capacity) {
        if (courseExists(code)) return Message.COURSE_ALREADY_EXISTS;

        int index = findEmptyCourseIndex();

        if (index == -1) return Message.ARRAY_IS_FULL;

        courses[index] = new Course(code, name, capacity);

        return Message.SUCCESS;

    }

    static Message enrollStudent(int studentId, int courseCode) {
        


        return Message.SUCCESS;
    }


    // =====================|Helper Methods|=====================
    static int findEmptyCourseIndex() {
        int targetIndex;

        for (int index = 0; index < courses.length; index++) {
            if (courses[index] == null) {
                targetIndex = index;
                return targetIndex;
            }
        }

        return -1;
    }

    static boolean courseExists(int code) {
        for (Course course : courses) {
            if (course.getCode() == code) {
                 return true; 
            }
        }

        return false;
    }

    static boolean StudentExists(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        
        return false;
    }
}