package portal.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.j4ml.dao.mapper.SysUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-*.xml" })
public class TestClass {
	
	@Resource SysUserMapper sysUserMapper;
	
	@Test
	public void test() {
		System.out.println(111);
		
	}

}
