package editdistancedyn;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Senese Andrea
 *
 */

public class Dyn_Distance_Test_Runner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(EditDistanceDynTests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }

}
