package com.lvaihua.springcloud;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class GateWayMain9527Test
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test01(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);
    }

    @Test
    public void test02(){
       String s = new String();
        System.out.println("s = " + s);
    }
}
