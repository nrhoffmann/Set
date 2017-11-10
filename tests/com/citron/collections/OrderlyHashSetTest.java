package com.citron.collections;

import org.junit.Test;

import java.util.ArrayList;

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
    @Test
    public void removeTest()
    {
        OrderlyHashSet<String> testSet = new OrderlyHashSet<>();
        for(int i = 'A'; i < 'J'; i++)
        {
            testSet.add("" + (char)i);
        }
        testSet.remove("F");

        assertFalse(testSet.contains("F"));
    }
    @Test
    public void containsAllTest()
    {
        ArrayList<String> a1 = new ArrayList<>();
        for(int i = 'A'; i < 'J'; i++)
        {
            a1.add("" + (char)i);
        }
        OrderlyHashSet<String> testSet = new OrderlyHashSet<>();
        for(int i = 'A'; i < 'J'; i++)
        {
            testSet.add("" + (char)i);
        }
        assertTrue(testSet.containsAll(a1));
        testSet.remove("B");
        assertFalse(testSet.containsAll(a1));
    }
    @Test
    public void removeAllTest()
    {
        ArrayList<String> a1 = new ArrayList<>();
        for(int i = 'A'; i < 'J'; i++)
        {
            a1.add("" + (char)i);
        }
        OrderlyHashSet<String> testSet = new OrderlyHashSet<>();
        for(int i = 'A'; i < 'J'; i++)
        {
            testSet.add("" + (char)i);
        }
        assertTrue(testSet.removeAll(a1));
        assertTrue(testSet.isEmpty());
        assertFalse(testSet.removeAll(a1));
        testSet.add("C");
        assertTrue(testSet.removeAll(a1));
    }
    @Test
    public void addAllTest()
    {

        ArrayList<String> a1 = new ArrayList<>();
        for(int i = 'A'; i < 'J'; i++)
        {
            a1.add("" + (char)i);
        }
        OrderlyHashSet<String> testSet = new OrderlyHashSet<>(10);
        assertTrue(testSet.addAll(a1));
        assertTrue(testSet.containsAll(a1));
    }



}
