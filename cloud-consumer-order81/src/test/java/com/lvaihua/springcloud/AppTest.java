package com.lvaihua.springcloud;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test1(){
        System.out.println(Integer.MAX_VALUE);
    }
}
