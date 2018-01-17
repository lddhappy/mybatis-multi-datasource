package net.lddhappy.config;

import com.alibaba.druid.pool.DruidDataSource;
import net.lddhappy.data.mapper.common.TbProjInfoMapper;
import net.lddhappy.data.model.common.DbConfig;
import net.lddhappy.data.model.common.TbProjInfo;
import net.lddhappy.util.DbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liudongdong on 18/1/17.
 */
@Component("mdnetDataSource")
public class MdnetDataSource extends AbstractRoutingDataSource {
    @Autowired
    public MdnetDataSource(TbProjInfoMapper tbProjInfoMapper, CommonDbProperties commonDbProperties) {
        List<TbProjInfo> projs = tbProjInfoMapper.selectAll();
        Map<Object, Object> datasources = new HashMap<>();
        projs.forEach(pi -> {
            DbConfig dbConfig = DbConfig.parseConfig(pi.getConnectString());
            DruidDataSource dataSource = DbUtil.initDruidDataSource(
                    commonDbProperties.getDriver(), dbConfig.getUrl(), dbConfig.getUid(), dbConfig.getPwd()
            );
            datasources.put(pi.getID(), dataSource);
        });
        setTargetDataSources(datasources);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getProjectID();
    }
}
