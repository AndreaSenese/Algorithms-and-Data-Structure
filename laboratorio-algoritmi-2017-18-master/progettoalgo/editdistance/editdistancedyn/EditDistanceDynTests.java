package editdistancedyn;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 *
 * @author Senese Andrea
 *
 */

public class EditDistanceDynTests{
  
@Test
  public void testZeroDistance() throws Exception{
  	String s1 = "pioppo";
  	String s2 = "pioppo";
  	assertEquals(0, Edit_Distance_Dyn.distance(s1, s2));
  }

  @Test
  public void testOneDistance() throws Exception{
  	String s1 = "casa";
  	String s2 = "cassa";
  	assertEquals(1, Edit_Distance_Dyn.distance(s1, s2));
  }

  @Test
  public void testTwoDistance() throws Exception{
  	String s1 = "casa";
  	String s2 = "cara";
  	assertEquals(2, Edit_Distance_Dyn.distance(s1, s2));
  }

  @Test
  public void testFourDistance() throws Exception{
  	String s1 = "tassa";
  	String s2 = "passato";
  	assertEquals(4, Edit_Distance_Dyn.distance(s1, s2));
  }
}








