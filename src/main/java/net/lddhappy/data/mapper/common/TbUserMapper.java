package net.lddhappy.data.mapper.common;

import net.lddhappy.data.model.common.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer ID);

    List<TbUser> selectAll();

    List<TbUser> selectWithSql(@Param("sql") String sql);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}