package net.lddhappy.data.mapper.common;

import net.lddhappy.MybatisMultiDatsourceApplication;
import net.lddhappy.data.model.common.TbUser;
import net.lddhappy.data.model.common.TbUserReadOnly;
import net.lddhappy.data.model.common.TbUserWithCompany;
import net.lddhappy.data.model.parameter.TbUserQueryParameter;
import org.apache.ibatis.cursor.Cursor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Liudongdong on 18/1/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisMultiDatsourceApplication.class)
public class TbUserMapperTest {
    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private MyBatisCursorItemReader<TbUser> userMyBatisCursorItemReader;

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

    @Test
    public void selectAllReturnMapTest() {
        List<HashMap> map = userMapper.selectAllReturnMap();
        assert map != null;
    }

    @Test
    public void selectWithParameterTest() {
        TbUserQueryParameter pa = new TbUserQueryParameter();
        pa.setTableName("tb_user");
        pa.setUserID(1);
        TbUser user = userMapper.selectWithParameter(pa);
        assert user != null;


    }

    @Test
    public void selectAllReturnCursorTest() {
        Cursor<TbUser> userCursor = userMapper.selectAllReturnCursor();
        Iterator<TbUser> userIterator = userCursor.iterator();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next());
        }
    }

    @Test
    public void cursorItemReaderTest() {
        try {
            userMyBatisCursorItemReader.open(new ExecutionContext());
            TbUser user;
            while ((user = userMyBatisCursorItemReader.read()) != null) {
                System.out.println(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            userMyBatisCursorItemReader.close();
        }
    }

    @Test
    public void selectReadOnlyTest() {
        List<TbUserReadOnly> readOnlies = userMapper.selectReadOnly();
        readOnlies.forEach(System.out::println);
    }

    @Test
    public void selectUserCompanyTest() {
        List<TbUserWithCompany> userWithCompanies = userMapper.selectUserCompany();
        assert userWithCompanies.size() > 0;
    }
}
















