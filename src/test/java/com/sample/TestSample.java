package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSample {  

    @BeforeAll  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
    @BeforeEach  
    public void setUp() throws Exception {  
        System.out.println("before");  
    }  
  

    public int findMax(int arr[]){  
        int max=arr[0];//arr[0] instead of 0  
        for(int i=1;i<arr.length;i++){  
            if(max<arr[i])  
                max=arr[i];  
        }  
        return max;  
    }  
  
    @Test  
    public void testFindMax(){  
        System.out.println("test case find max success");  
        assertEquals(4,findMax(new int[]{1,3,4,2}));  
   
    } 
    @Test  
    public void testFindMaxFail(){  
        System.out.println("test case find max fail");  
        assertEquals(6,findMax(new int[]{1,3,4,6}));  
      
    }    
}  