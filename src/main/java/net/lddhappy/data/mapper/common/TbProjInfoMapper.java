package net.lddhappy.data.mapper.common;

import net.lddhappy.data.model.common.TbProjInfo;

import java.util.List;

public interface TbProjInfoMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(TbProjInfo record);

    int insertSelective(TbProjInfo record);

    TbProjInfo selectByPrimaryKey(Integer ID);

    List<TbProjInfo> selectAll();

    int updateByPrimaryKeySelective(TbProjInfo record);

    int updateByPrimaryKeyWithBLOBs(TbProjInfo record);

    int updateByPrimaryKey(TbProjInfo record);
}