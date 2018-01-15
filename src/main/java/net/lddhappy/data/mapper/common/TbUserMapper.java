package net.lddhappy.data.mapper.common;

import net.lddhappy.data.model.common.TbUser;
import net.lddhappy.data.model.parameter.TbUserQueryParameter;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

import java.util.HashMap;
import java.util.List;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer ID);

    List<TbUser> selectAll();

    Cursor<TbUser> selectAllReturnCursor();

    List<HashMap> selectAllReturnMap();

    List<TbUser> selectWithSql(@Param("sql") String sql);

    TbUser selectWithParameter(TbUserQueryParameter pa);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}