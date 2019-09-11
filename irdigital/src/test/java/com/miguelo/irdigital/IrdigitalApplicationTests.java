package com.miguelo.irdigital;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.miguelo.irdigital.util.Util;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IrdigitalApplicationTests {

    @Test
    public void contextLoads() {
    	System.out.println(Util.calculateDateDead("02/08/2019"));
    	
    }

}
