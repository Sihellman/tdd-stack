package edu.htc.blitstein.caih313.tddstack.engine;
import static org.junit.Assert.*;

import edu.htc.blitstein.caih313.tddstack.IStackable;
import edu.htc.blitstein.caih313.tddstack.resource.campus.Faculty;
import edu.htc.blitstein.caih313.tddstack.resource.campus.Student;
import edu.htc.blitstein.caih313.tddstack.resource.room.ComputerLab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TddStackTest  {
    TddStack tdd;
    IStackable obj1 = new Student();
    IStackable obj2 = new Faculty();
    IStackable obj3 = new ComputerLab();

    @Before
    public void setUp() throws Exception {
        tdd = new TddStack();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSet(){

        int expected = TddStack.DEFAULT_DEPTH;
        TddStack objresult = new TddStack();
        int result = objresult.stackDepth;
        assertEquals(expected, result, 0.001);

    }


    @Test
    public void testNewStackIsEmpty() {
        TddStack tddStack = new TddStack();
        assertTrue(tddStack.isEmpty());
    }
    @Test
    public void testNewStackIsFull(){
        TddStack objresult = new TddStack();
        assertFalse(objresult.isFull());

    }
    @Test
    public void testAddOneIsNotEmptyAndIsNotFull() {
        TddStack tddStack = new TddStack(3);
        Student student = new Student();
        tddStack.push(student);
        assertFalse(tddStack.isEmpty());
        assertFalse(tddStack.isFull());
    }
    @Test
    public void testPopIsPush() {
        TddStack tddStack = new TddStack();
        //Faculty implements IStackable
        tddStack.push(obj1);
        tddStack.push(obj2);
        tddStack.push(obj3);
        IStackable iStackablePopped = tddStack.pop();
        assertEquals(obj3, iStackablePopped);
    }
    @Test
    public void testPopEmpty() {
        TddStack tddStack = new TddStack();
        assertNull(tddStack.pop());
    }
    @Test
    public void testPush(){
        TddStack tddStack = new TddStack();
        IStackable obj = new Faculty();
        tddStack.push(obj);
        assertEquals(0, tddStack.getCurrentNumber());


        TddStack expectedObj = new TddStack();
        IStackable[] storage1 = tddStack.getStorage();
        IStackable[] storage2 = expectedObj.getStorage();
        storage2[0] = obj;


        for (int i = 0; i < storage1.length; i++){
            assertEquals(storage1[i], storage2[i]);
        }


    }
    @Test
    public void testPushEmpty(){
        TddStack objresult = new TddStack();
        objresult.push(obj1);
        assertFalse(objresult.isEmpty());

    }
    @Test
    public void testPushFull(){

        TddStack objresult = new TddStack(3);


        objresult.push(obj1);
        objresult.push(obj2);
        objresult.push(obj3);
        assertTrue(objresult.isFull());

    }
    @Test
    public void testPop(){
        TddStack tddStack = new TddStack();
        IStackable obj = new Faculty();
        tddStack.push(obj);
        tddStack.pop();
        assertEquals(-1, tddStack.getCurrentNumber());


        TddStack expectedObj = new TddStack();
        IStackable[] storage1 = tddStack.getStorage();
        IStackable[] storage2 = expectedObj.getStorage();
        storage2[0] = null;


        for (int i = 0; i < storage1.length; i++) {
            assertEquals(storage1[i], storage2[i]);
        }


    }




}