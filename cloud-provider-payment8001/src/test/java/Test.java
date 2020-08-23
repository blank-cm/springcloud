import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.springcloud.PaymentMain8001;
import com.atguigu.springcloud.Dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=PaymentMain8001.class)
public class Test {
	@Resource
	private PaymentMapper paymentMapper;
	@org.junit.Test
	public void test(){
		Payment p = paymentMapper.selectPaymentById(1);
		System.out.println(p);
	}
}
