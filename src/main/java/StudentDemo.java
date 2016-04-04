import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class StudentDemo {

    public static void main(String[] args) throws SQLException {
            StudentDAOMySQL studentDAO = new StudentDAOMySQL();
            StudentService studentService = new StudentService(studentDAO);

            Student student1 = new Student();
            student1.setFname("Petro");
            student1.setLname("Gorbenko");
            student1.setGroup("KI-13-3");
            student1.setAge(19);

            Student student2 = new Student();
            student2.setFname("Ivan");
            student2.setLname("Ivanov");
            student2.setGroup("KI-12-4");
            student2.setAge(21);

            Student student3 = new Student();
            student2.setFname("Bogdan");
            student2.setLname("Razum");
            student2.setGroup("KI-13-3");
            student2.setAge(20);

            studentService.createStudent(student1);
            studentService.createStudent(student2);
            studentService.createStudent(student3);

            List<Student> studentsByGroup = studentService.getStudentByGroup("KI-12-4");
            System.out.println("Student with group KI-12-4: " + studentsByGroup);

            studentsByGroup = studentService.getStudentByGroup("KI-12-3");
            student1 = studentsByGroup.get(0);
            student1.setGroup("KI-12-4");
            studentService.updateStudent(student1);
            studentsByGroup = studentService.getStudentByGroup("KI-12-4");
            System.out.println("Student with group KI-12-4: " + studentsByGroup);
            studentDAO.DeleteStudent();

     /*   studentService.deleteStudent(student1,student1);*/
          /*studentService.deleteStudent(Student, );*/
      /*  studentService.deleteStudent(student1);*/
                 /*studentDAO.DeleteStudent(String title,1);*/







    }
}
