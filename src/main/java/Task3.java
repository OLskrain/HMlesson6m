
import java.sql.*;

public class Task3 {
    private Connection connection;
    private Statement statement;
    private PreparedStatement prepStat;
    private Savepoint spl;
    ResultSet resultSet;
    private final String STUDENTS = "студент";

    public void connect() throws SQLException, ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Javaprolesson6m.db");
        statement = connection.createStatement();
    }
    public void createTable() throws SQLException{
        statement.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT, surname TEXT, score INTEGER);");
    }
    public void dropTable()throws SQLException{
        statement.execute("DROP TABLE students");
    }
    public void addStudents()throws SQLException{
        connection.setAutoCommit(false);
        prepStat = connection.prepareStatement("INSERT INTO students(surname , score) VALUES (?,?);");
        for (int i = 0; i < 10; i++) {
            prepStat.setString(1, STUDENTS+(i+1));
            prepStat.setInt(2,(i+1)*10);
            prepStat.addBatch();
        }
        prepStat.executeBatch();
        connection.commit();
    }
    public String getData(String testSurname) throws SQLException{
        String st;
        resultSet = statement.executeQuery("SELECT surname, score FROM students WHERE surname == '"+testSurname+"'");

        while(resultSet.next()) return st =(resultSet.getString("surname") + " " + resultSet.getInt("score"));
        return (null);
    }
    public void transactionsAddStudents(String testSurname, String testScore)throws SQLException{
        connection.setAutoCommit(false);
        spl = connection.setSavepoint();
        statement.execute("INSERT INTO students(surname, score) VALUES ('"+testSurname+"','"+testScore+"');");
        //connection.rollback(spl);
    }
    public void transactionsUpdateData(String testSurname, String testScore) throws SQLException{
        connection.setAutoCommit(false);
        spl = connection.setSavepoint();
        statement.executeUpdate("UPDATE students SET score = '"+testScore+"' WHERE surname ='"+testSurname+"'");
    }
    public void backToSave()throws SQLException{
        connection.rollback(spl);
        connection.commit();
    }
    public void disconnect(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
