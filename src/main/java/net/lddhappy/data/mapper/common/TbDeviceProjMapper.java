package net.lddhappy.data.mapper.common;

import net.lddhappy.data.model.common.TbDeviceProj;

import java.util.List;

public interface TbDeviceProjMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(TbDeviceProj record);

    void insertSelectKey(TbDeviceProj deviceProj);

    void insertBatch(List<TbDeviceProj> devices);

    int insertSelective(TbDeviceProj record);

    TbDeviceProj selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(TbDeviceProj record);

    int updateByPrimaryKey(TbDeviceProj record);

}