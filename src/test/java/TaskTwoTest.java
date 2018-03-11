import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTwoTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4}},
                {new int[]{5,2,3,4}},
                {new int[]{1,2,3,9}},
                {new int[]{13,2,3,32}}
        });
    }
    private int [] masstest2;

    public TaskTwoTest(int[] masstest2) {
        this.masstest2 = masstest2;
    }
    Task2 task2;

    @Before
    public void init(){
        task2 = new Task2();
    }

    @Test
    public void arrayCheckTest(){
        Assert.assertTrue(task2.arrayCheck(masstest2));
    }
}
