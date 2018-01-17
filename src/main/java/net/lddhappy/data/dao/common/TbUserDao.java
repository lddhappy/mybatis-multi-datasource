package net.lddhappy.data.dao.common;

import net.lddhappy.data.mapper.common.TbUserMapper;
import net.lddhappy.data.model.common.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Liudongdong on 18/1/17.
 */
@Component
public class TbUserDao {
    @Autowired
    private TbUserMapper userMapper;

    @Transactional(transactionManager = "commonDataSourceTransactionManager")
    public List<TbUser> selectAllUser() {
        return userMapper.selectAll();
    }
}
