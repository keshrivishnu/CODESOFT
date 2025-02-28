import java.util.ArrayList;
import java.util.List;
    class Course {
        String courseCode;
        String title;
        String description;
        int capacity;
        String schedule;
        List<String> registeredStudents;

        public Course(String courseCode, String title, String description, int capacity, String schedule) {
            this.courseCode = courseCode;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.schedule = schedule;
            this.registeredStudents = new ArrayList<>();
        }

        public boolean isFull() {
            return registeredStudents.size() >= capacity;
        }

        public boolean registerStudent(String studentID) {
            if (!isFull() && !registeredStudents.contains(studentID)) {
                registeredStudents.add(studentID);
                return true;
            }
            return false;
        }

        public void removeStudent(String studentID) {
            registeredStudents.remove(studentID);
        }

        @Override
        public String toString() {
            return "Course Code: " + courseCode + ", Title: " + title + ", Schedule: " + schedule +
                    ", Capacity: " + capacity + ", Registered: " + registeredStudents.size();
        }
    }

    class CourseCatalog {
        private List<Course> courses = new ArrayList<>();

        public void addCourse(Course course) {
            courses.add(course);
        }

        public Course getCourse(String courseCode) {
            for (Course course : courses) {
                if (course.courseCode.equals(courseCode)) {
                    return course;
                }
            }
            return null;
        }

        public void displayAvailableCourses() {
            for (Course course : courses) {
                if (!course.isFull()) {
                    System.out.println(course);
                }
            }
        }
    }

    class Student {
        String studentID;
        String name;
        List<String> registeredCourses;

        public Student(String studentID, String name) {
            this.studentID = studentID;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }

        public void registerForCourse(String courseCode, CourseCatalog catalog) {
            Course course = catalog.getCourse(courseCode);
            if (course != null) {
                if (course.registerStudent(this.studentID)) {
                    this.registeredCourses.add(courseCode);
                    System.out.println(name + " registered for " + courseCode);
                } else {
                    System.out.println("Course " + courseCode + " is full or student is already registered.");
                }
            } else {
                System.out.println("Course " + courseCode + " not found.");
            }
        }

        public void dropCourse(String courseCode, CourseCatalog catalog) {
            Course course = catalog.getCourse(courseCode);
            if (course != null && registeredCourses.contains(courseCode)) {
                course.removeStudent(this.studentID);
                registeredCourses.remove(courseCode);
                System.out.println(name + " dropped " + courseCode);
            } else {
                System.out.println("Not registered for " + courseCode + " or course not found.");
            }
        }
        @Override
        public String toString() {
            return "Student ID: " + studentID + ", Name: " + name;
        }

    }

    public class taskfive {

        private CourseCatalog catalog = new CourseCatalog();
        private StudentRoster roster = new StudentRoster();

        public static void main(String[] args) {
            taskfive system = new taskfive(); // Corrected object creation

            Course course1 = new Course("CS101", "Intro to Programming", "Basic programming concepts", 3, "Mon/Wed 9:00");
            system.catalog.addCourse(course1);

            Student student1 = new Student("S001", "Alice");
            system.roster.addStudent(student1);

            student1.registerForCourse("CS101", system.catalog);
            system.catalog.displayAvailableCourses();
            student1.dropCourse("CS101", system.catalog);
            system.catalog.displayAvailableCourses();

        }
    }

    class StudentRoster {
        private List<Student> students = new ArrayList<>();

        public void addStudent(Student student) {
            students.add(student);
        }

        public Student getStudent(String studentID) {
            for (Student student : students) {
                if (student.studentID.equals(studentID)) {
                    return student;
                }
            }
            return null;
        }
    }
