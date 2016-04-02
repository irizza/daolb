import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.jdbc.Statement;

public class StudentDAOMySQL {

    private static final String SQL_UPDATE_STUDENT = "UPDATE students SET fname = ?, lname = ?, "
            + "groups = ?, age = ? WHERE id_students = ? ";
    private static final String SQL_INSERT_INTO_STUDENT = "INSERT INTO students (fname, lname, groups, age)"
            + " VALUES (?,?,?,?)";
    private static final String SQL_SELECT_BY_GROUPS = "SELECT * FROM students WHERE groups = ?";
    /**/
    private static final String SQL_DELETE_BY_ID = "DELETE  FROM students WHERE tittle = ?";



    /**/
    public void create(Connection connection, Student student) throws SQLException {
        PreparedStatement prStatement = connection.prepareStatement(SQL_INSERT_INTO_STUDENT,
                Statement.RETURN_GENERATED_KEYS);
        setInsertStatementParameters(student, prStatement);
        prStatement.executeUpdate();
        prStatement.close();
    }

    public void update(Connection connection, Student student) throws SQLException {
        PreparedStatement prStatement = connection.prepareStatement(SQL_UPDATE_STUDENT);
        setUpdateStatementParameters(student, prStatement);
        prStatement.executeUpdate();
        prStatement.close();
    }

    public List<Student> getByGroup(Connection connection, String group) throws SQLException {
        PreparedStatement prStatement = connection.prepareStatement(SQL_SELECT_BY_GROUPS);
        prStatement.setString(1, group);
        ResultSet rs = prStatement.executeQuery();
        List<Student> students = getStudents(rs);
        prStatement.close();
        return students;
    }

    private List<Student> getStudents(ResultSet rs) throws SQLException {
        List<Student> students = new ArrayList<Student>();
        while (rs.next())
            students.add(getStudent(rs));
        return students;
    }

    private Student getStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id_students"));
        student.setFname(rs.getString("fname"));
        student.setLname(rs.getString("lname"));
        student.setGroup(rs.getString("groups"));
        student.setAge(rs.getInt("age"));
        return student;
    }

    private void setUpdateStatementParameters(Student student, PreparedStatement prStatement) throws SQLException {
        int k = 1;
        prStatement.setString(k++, student.getFname());
        prStatement.setString(k++, student.getLname());
        prStatement.setString(k++, student.getGroup());
        prStatement.setInt(k++, student.getAge());
        prStatement.setLong(k++, student.getId());
    }

    private void setInsertStatementParameters(Student student, PreparedStatement prStatement) throws SQLException {
        int k = 1;
        prStatement.setString(k++, student.getFname());
        prStatement.setString(k++, student.getLname());
        prStatement.setString(k++, student.getGroup());
        prStatement.setInt(k++, student.getAge());
    }
    /**/
    public void delete(Connection connection, Student student) throws SQLException {
        PreparedStatement prStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
        setDeleteStatementParameters(student,prStatement);
        prStatement.executeUpdate();
      //  prStatement.
      //  prStatement.close();


        

    }

    private void setDeleteStatementParameters(Student student, PreparedStatement prStatement) throws SQLException {
        int k = 1;
        prStatement.setString(k++, student.getFname());
        prStatement.setString(k++, student.getLname());
        prStatement.setString(k++, student.getGroup());
        prStatement.setInt(k++, student.getAge());

        prStatement.executeUpdate("DELETE * FROM filials.students");

    }


}



