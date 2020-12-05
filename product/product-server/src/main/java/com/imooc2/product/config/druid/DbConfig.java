package com.imooc2.product.config.druid;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * @Author snail
 * @Description:
 * @create: 2020-06-10 16:52
 * @Param $
 * @return $
 * @Version 1.0
 **/
public interface DbConfig {

    /**
     * 定义数据源
     *
     * @return
     * @throws Exception
     */
    DataSource  dataSource() throws Exception;

    /**
     * 定义session工厂
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception;

    /**
     * 定义失误管理器
     *
     * @param dataSource
     * @return
     */
    DataSourceTransactionManager transactionManager(DataSource dataSource);

}