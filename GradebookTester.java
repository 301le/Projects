import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class GradebookTester
{  
   private GradeBook g1;
   private GradeBook g2;

   @Before
   public void setUp()
   {
       g1 = new GradeBook(5);
       g2 = new GradeBook(5);

       g1.addScore(50.0);
       g1.addScore(75.0);

       g2.addScore(55.0);
       g2.addScore(12.0);
       g2.addScore(47.0);
   }

   @After
   public void tearDown()
   {
       g1 = null;
       g2 = null;
   }
   
   @Test
   public void testSum()
   {
       assertEquals(125.0, g1.sum(), 0.0001);
       assertEquals(114.0, g2.sum(), 0.0001);
   }

   @Test
   public void testMinimum()
   {
       assertEquals(50.0, g1.minimum(), 0.001);
       assertEquals(12.0, g2.minimum(), 0.001);
   }
   
   @Test
   public void addScoreTest()
   {
       assertTrue((g1.toString()).equals("50.0 75.0 "));
       assertTrue((g2.toString()).equals("55.0 12.0 47.0 "));

       assertEquals(2, g1.getScoreSize(), 0.001);
       assertEquals(3, g2.getScoreSize(), 0.001);
   }

   @Test
   public void testFinalScore()
   {
       assertEquals(75.0, g1.finalScore(), 0.001);
       assertEquals(102.0, g2.finalScore(), 0.001);
   }
}