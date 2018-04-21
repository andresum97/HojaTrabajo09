/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo9;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dodi-
 */
public class SplayBSTTest {
    
    public SplayBSTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of contains method, of class SplayBST.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object key = null;
        SplayBST instance = new SplayBST();
         instance.put("House", "Casa");
        boolean expResult = true;
        boolean result = instance.contains("House");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of get method, of class SplayBST.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Object key = null;
        SplayBST instance = new SplayBST();
       instance.put("House", "Casa");
        String expResult = "Casa";
        String result = (String) instance.get("House");
        if (!result.equals(expResult)){
            fail("Error");
        }
        
    }

    /**
     * Test of put method, of class SplayBST.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Object key = null;
        Object value = null;
        SplayBST instance = new SplayBST();
        instance.put("House", "Casa");
        String expResult = "Casa";
        String result = (String) instance.get("House");
       // instance.put(key, val);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)){
            fail("Error");
        }
    }

    
}
