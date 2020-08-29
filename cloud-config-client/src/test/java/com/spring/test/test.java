package com.spring.test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.springcloud.ConfigClientMain3355;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ConfigClientMain3355.class)
public class test {
	@Test
	public void testOne(){
		HttpClientUtil.doPost("http://localhost:3355/actuator/refresh");
	}
}
