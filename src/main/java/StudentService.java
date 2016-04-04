import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private StudentDAOMySQL studentDAO;

    public StudentService(StudentDAOMySQL studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void createStudent(Student student) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            studentDAO.create(connection, student);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public void updateStudent(Student student) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            studentDAO.update(connection, student);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public List<Student> getStudentByGroup(String group) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            List<Student> students = studentDAO.getByGroup(connection, group);
            connection.commit();
            return students;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }


    /**/
 /*   public void deleteStudent(Student student) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            studentDAO.delete(connection, student);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }*/

}
