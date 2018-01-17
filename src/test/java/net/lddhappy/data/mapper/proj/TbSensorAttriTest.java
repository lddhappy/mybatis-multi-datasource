package net.lddhappy.data.mapper.proj;

import net.lddhappy.MybatisMultiDatsourceApplication;
import net.lddhappy.config.DbContextHolder;
import net.lddhappy.data.model.proj.TbSensorAttri;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Liudongdong on 18/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MybatisMultiDatsourceApplication.class})
public class TbSensorAttriTest {
    @Autowired
    private TbSensorAttriMapper sensorAttriMapper;

    @Test
    public void selectAllTest() {
        DbContextHolder.setProjectID(5);
        List<TbSensorAttri> attriList = sensorAttriMapper.selectAll();

        DbContextHolder.setProjectID(67);
        List<TbSensorAttri> attriList2 = sensorAttriMapper.selectAll();
        System.out.println(attriList.size());
    }
}
