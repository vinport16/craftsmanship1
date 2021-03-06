import static org.junit.Assert.assertEquals;
import org.junit.Test;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class Tests {

    public static void main(String[] args){
      
      Result result = JUnitCore.runClasses(InternalNodeTests.class);
      for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
      }
      result = JUnitCore.runClasses(LeafNodeTests.class);
      for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
      }
      result = JUnitCore.runClasses(CacheTests.class);
      for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
      }
      result = JUnitCore.runClasses(VariableTests.class);
      for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
      }
      result = JUnitCore.runClasses(ConnectorTests.class);
      for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
      }
    }
}