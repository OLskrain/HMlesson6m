
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskThreeTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"Rick","100","Rick 100"},
                {"Rick","100","Rick100"},
                {"студент1","10","студент1 10"},
                {"студент1","1000","студент1 1000"}
        });
    }

    private String testSurname;
    private String testScore;
    private String expectation;

    public TaskThreeTest(String testSurname, String testScore, String expectation) {
        this.testSurname = testSurname;
        this.testScore = testScore;
        this.expectation = expectation;
    }

    Task3 task3;

    @Before
  public void init()throws ClassNotFoundException{
      task3 = new Task3();
        try {
            task3.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Test
public void addBDTest(){
    try {
        task3.transactionsAddStudents(testSurname,testScore);
        Assert.assertEquals(expectation, task3.getData(testSurname));
        task3.backToSave();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
@Test
    public void readBDTest(){
    try {
        Assert.assertEquals(expectation, task3.getData(testSurname));
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
@Test
public void updateTest(){
    try {
        task3.transactionsUpdateData(testSurname,testScore);
        Assert.assertEquals(expectation, task3.getData(testSurname));
        task3.backToSave();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
@After
    public void end(){
    task3.disconnect();
}
}
