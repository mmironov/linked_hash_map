package com.musala;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class LinkedHashMapTests {

    private static LinkedHashMap<String, Integer> map;

    @BeforeClass
    public static void setupTestFixture() {
        map = new LinkedHashMap<>();
    }

    @After
    public void teardown() {
        map.clear();
    }

    @Test
    public void newMapShouldBeEmpty() {

        int expected = 0;

        int actual = map.size();

        assertEquals(expected, actual);
    }

    @Test
    public void addingFirstElement() {

        String key = "one";
        int value = 1;
        map.insert("one", 1);

        int valueFromMap = map.get(key);

        assertEquals(value, valueFromMap);
    }

    @Test(timeout = 1000)
    public void mapIsEmptyAfterClear() {

        for(int i=0; i < 5; ++i) {
            map.insert(String.valueOf(i), i);
        }

        map.clear();

        assertEquals(0, map.size() + 1);
    }

    @Test
    public void valueShouldBeMissing() {

        map.insert("two", 2);

        Integer value = map.get("five");

        assertNull(value);
    }

    //@Test(expected = Exception.class)

    //@Test(timeout=1000)


    //Assert statements
    //fail
    //assertTrue
    //assertFalse
    //assertEquals
    //assertNull
    //assertNotNull
    //assertSame
    //assertNotSame
}
