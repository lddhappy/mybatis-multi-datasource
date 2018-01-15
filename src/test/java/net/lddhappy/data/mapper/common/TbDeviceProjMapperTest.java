package net.lddhappy.data.mapper.common;

import net.lddhappy.MybatisMultiDatsourceApplication;
import net.lddhappy.data.model.common.TbDeviceProj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Liudongdong on 18/1/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisMultiDatsourceApplication.class)
public class TbDeviceProjMapperTest {
    @Autowired
    private TbDeviceProjMapper deviceProjMapper;

    @Test
    public void insertBatchTest() {
        List<TbDeviceProj> deviceProjs = Arrays.asList(
                new TbDeviceProj("180001T", 5, 0, null),
                new TbDeviceProj("180002T", 5, 1, null),
                new TbDeviceProj("180003T", 5, 2, "设备备注")
        );
        deviceProjMapper.insertBatch(deviceProjs);
        System.out.println(
                deviceProjs
                        .stream()
                        .map(d -> d.getID().toString())
                        .reduce((i1, i2) -> i1.toString() + "," + i2.toString())
        );
    }

    @Test
    public void insertSelectTest() {
        TbDeviceProj deviceProj = new TbDeviceProj("180004T", 5, 0, null);
        deviceProjMapper.insertSelectKey(deviceProj);
        System.out.println(deviceProj.getID());
    }
}
