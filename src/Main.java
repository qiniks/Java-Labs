import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private Set<String> courses;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new HashSet<>();
    }

    public int getId() {
        return id;
    }

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

    public Set<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public String toString() {
        return "ID: " + id + " name:" + name + " age:" + age + " courses:" + courses;
    }
}

class Management {
    private Map<Integer, Student> studentsById;
    private Map<String, Set<Student>> studentsByCourse;

    public Management() {
        studentsById = new HashMap<>();
        studentsByCourse = new HashMap<>();
    }

    public void addStudent(int id, String name, int age) {
        Student student = new Student(id, name, age);
        studentsById.put(id, student);
        System.out.println("Added: " + student);
    }

    public void removeStudent(int id) {
        Student student = studentsById.remove(id);
        if (student != null) {
            for (String course : student.getCourses()) {
                Set<Student> studentsInCourse = studentsByCourse.get(course);
                studentsInCourse.remove(student);
                if (studentsInCourse.isEmpty()) {
                    studentsByCourse.remove(course);
                }
            }
            System.out.println("Removed: " + student);
        }
    }

    public void updateStudent(int id, String name, Integer age, Set<String> courses) {
        Student student = studentsById.get(id);
        if (name != null) {
            student.setName(name);
        }
        if (age != null) {
            student.setAge(age);
        }
        if (courses != null) {
            for (String oldCourse : student.getCourses()) {
                Set<Student> studentsInCourse = studentsByCourse.get(oldCourse);
                studentsInCourse.remove(student);
            }
            student.getCourses().clear();
            for (String course : courses) {
                student.addCourse(course);
                if (!studentsByCourse.containsKey(course)) {
                    studentsByCourse.put(course, new HashSet<>());
                }
                studentsByCourse.get(course).add(student);
            }
        }
        System.out.println("Updated: " + student);
    }

    public void displayStudentsById() {
        List<Student> sortedStudents = new ArrayList<>(studentsById.values());
        Collections.sort(sortedStudents, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getId() - s2.getId();
            }
        });
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
    }

    public void searchStudentById(int id) {
        Student student = studentsById.get(id);
        if (student != null) {
            System.out.println("Found: " + student);
        }
    }

    public void listStudentsByCourse(String course) {
        Set<Student> students = studentsByCourse.get(course);
        if (students != null) {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void displayStudentsByName() {
        TreeSet<Student> sortedByName = new TreeSet<>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        sortedByName.addAll(studentsById.values());
        for (Student student : sortedByName) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Management management = new Management();

        management.addStudent(1, "Talant", 20);
        management.addStudent(2, "Bektur", 22);
        management.addStudent(3, "Alex", 19);
        management.addStudent(4, "Barsbek", 19);


        management.updateStudent(3, null, null, new HashSet<>(Arrays.asList("Math Lab", "C++")));
        management.searchStudentById(2);
        management.listStudentsByCourse("Java");
        management.updateStudent(2, null, null, new HashSet<>(Arrays.asList("Java", "Python")));
        management.displayStudentsById();
        management.removeStudent(3);
        management.displayStudentsByName();
        management.listStudentsByCourse("Java");
    }
}