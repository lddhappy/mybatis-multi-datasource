package net.lddhappy.data.mapper.proj;

import net.lddhappy.data.model.proj.TbSensorAttri;

import java.util.List;

public interface TbSensorAttriMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(TbSensorAttri record);

    int insertSelective(TbSensorAttri record);

    TbSensorAttri selectByPrimaryKey(Integer ID);

    List<TbSensorAttri> selectAll();

    int updateByPrimaryKeySelective(TbSensorAttri record);

    int updateByPrimaryKeyWithBLOBs(TbSensorAttri record);

    int updateByPrimaryKey(TbSensorAttri record);
}