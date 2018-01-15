package net.lddhappy.data.mapper.common;

import net.lddhappy.MybatisMultiDatsourceApplication;
import net.lddhappy.data.model.common.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Liudongdong on 18/1/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisMultiDatsourceApplication.class)
public class TbUserMapperTest {
    @Autowired
    private TbUserMapper userMapper;

    @Test
    public void testGetUser() {
        List<TbUser> users = userMapper.selectAll();
        assert users.size() > 0;
    }

    @Test
    public void selectWithSqlTest() {
        String sql = "select * from tb_user";
        List<TbUser> users = userMapper.selectWithSql(sql);
        assert users.size() > 0;
    }
}
