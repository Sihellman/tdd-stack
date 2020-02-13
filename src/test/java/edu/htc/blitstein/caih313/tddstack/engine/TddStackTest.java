package edu.htc.blitstein.caih313.tddstack.engine;
import static org.junit.Assert.*;

import edu.htc.blitstein.caih313.tddstack.IStackable;
import org.junit.After;
import org.junit.Before;

public class TddStackTest {
    TddStack tdd;
    IStackable obj1;
    IStackable obj2;
    IStackable obj3;

    @Before
    public void setUp() throws Exception {
        tdd = new TddStack();
    }

    @After
    public void tearDown() throws Exception {
    }

    public void testSet(){

        long expected = TddStack.DEFAULT_DEPTH;
        TddStack objresult = new TddStack();
        long result = objresult.stackDepth;
        assertEquals(expected, result, 0.001);

    }
    public void testIsEmpty(){


        TddStack objresult = new TddStack();
        boolean result = objresult.isEmpty();
        assertEquals(true, result);
    }
    public void testIsFull(){
        TddStack objresult = new TddStack();
        boolean result = objresult.isFull();
        assertEquals(false, result);

    }
    public void testPop(){
        TddStack objresult = new TddStack();
        IStackable result = objresult.pop();
        assertEquals(null, result);
    }
    public void testPushEmpty(){
        TddStack objresult = new TddStack();
        objresult.push(obj1);
        boolean result = objresult.isEmpty();
        assertEquals(false, result);

    }
    public void testPushFull(){
        TddStack objresult = new TddStack(3);
        objresult.push(obj1);
        objresult.push(obj2);
        objresult.push(obj3);
        boolean result = objresult.isFull();
        assertEquals(true, result);

    }


}