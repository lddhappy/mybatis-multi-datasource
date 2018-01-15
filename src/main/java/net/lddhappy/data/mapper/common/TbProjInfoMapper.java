package net.lddhappy.data.mapper.common;

import net.lddhappy.data.model.common.TbProjInfo;

public interface TbProjInfoMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(TbProjInfo record);

    int insertSelective(TbProjInfo record);

    TbProjInfo selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(TbProjInfo record);

    int updateByPrimaryKeyWithBLOBs(TbProjInfo record);

    int updateByPrimaryKey(TbProjInfo record);
}