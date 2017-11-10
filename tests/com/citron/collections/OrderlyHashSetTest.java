package com.citron.collections;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class OrderlyHashSetTest {


    @Test
    public void iterationTest()
    {
        OrderlyHashSet<String> testSet = new OrderlyHashSet<>();
        for(int i = 'A'; i < 'J'; i++)
        {
            testSet.add("" + (char)i);
        }
        for(String s: testSet)
        {
            System.out.println(s);
        }
    }
    @Test public void containsTest()
    {
        OrderlyHashSet<String> testSet = new OrderlyHashSet<>();
        for(int i = 'A'; i < 'J'; i++)
        {
            testSet.add("" + (char)i);
        }
       assertTrue(testSet.contains("A")&&testSet.contains("B")&&testSet.contains("I"));
        assertFalse(testSet.contains("S"));
    }

}
