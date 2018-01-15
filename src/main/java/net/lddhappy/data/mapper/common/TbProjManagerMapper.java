package net.lddhappy.data.mapper.common;

import net.lddhappy.data.model.common.TbProjManager;

public interface TbProjManagerMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(TbProjManager record);

    int insertSelective(TbProjManager record);

    TbProjManager selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(TbProjManager record);

    int updateByPrimaryKey(TbProjManager record);
}