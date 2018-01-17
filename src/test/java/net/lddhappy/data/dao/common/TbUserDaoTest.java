package net.lddhappy.data.dao.common;

import net.lddhappy.MybatisMultiDatsourceApplication;
import net.lddhappy.data.model.common.TbUser;
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
public class TbUserDaoTest {
    @Autowired
    private TbUserDao userDao;

    @Test
    public void selectAllTest() {
        List<TbUser> users = userDao.selectAllUser();
        System.out.println(users.size());
    }
}
