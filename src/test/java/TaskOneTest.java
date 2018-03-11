import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskOneTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {new int[]{1,2,4,4,2,3,4,1,7}, new int[]{1,7}},
                {new int[]{1,2,1,7}, new int[]{1,7}},
                {new int[]{1,2,4,7}, new int[]{8}},

        });
    }
    private int [] fastmass;
    private int [] resultmass;

    public TaskOneTest(int[] fastmass, int [] resultmass) {
        this.fastmass = fastmass;
        this.resultmass = resultmass;
    }
    Task1 task1;

    @Before
    public void init(){
        task1 = new Task1();
    }
    @Test(expected = RuntimeException.class)
    public void taskException(){
        task1.newMass(fastmass);
    }

    @Test
    public void newMassTest(){
        Assert.assertArrayEquals(resultmass, task1.newMass(fastmass));
    }
}
