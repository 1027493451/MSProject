package com.imooc2.product.config.druid;


import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @Author snail
 * @Description:
 * @create: 2020-06-10 16:53
 * @Param $
 * @return $
 * @Version 1.0
 **/
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = MyDruirdConfig.PACKAGE, sqlSessionFactoryRef = "sessionFactory")
public class MyDruirdConfig implements DbConfig {


    public static final String PACKAGE = "com.imooc2.product.**.dao";

    public static final String MAPPER = "classpath:/mapper/*Mapper.xml";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.max-active}")
    private int maxActive;

    @Value("${spring.datasource.max-wait}")
    private int maxWait;

    @Value("${spring.datasource.test-while-idle:true}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.time-between-eviction-runs-millis:60000}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.validation-query}")
    private String validationQuery;

    /**
     * 指明是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个.<br/>
     * 注意: 设置为true后如果要生效,validationQuery参数必须设置为非空字符串
     */
    @Value("${spring.datasource.test-on-borrow:true}")
    private boolean testOnBorrow;

    /**
     * 指明是否在归还到池中前进行检验<br/>
     * 注意: 设置为true后如果要生效,validationQuery参数必须设置为非空字符串
     */
    @Value("${spring.datasource.test-on-return:false}")
    private boolean testOnReturn;

    @Value("${spring.datasource.min-evictable-idle-time-millis:300000}")
    private int minEvictableIdleTimeMillis;

    /**
     * 当开启时, 将为每个连接创建一个statement池,并且被方法创建的PreparedStatements将被缓存起来:
     */
    @Value("${spring.datasource.pool-prepared-Statements:false}")
    private boolean poolPreparedStatements;

    /**
     * 不限制  statement池能够同时分配的打开的statements的最大数量,如果设置为0表示不限制
     */
    @Value("${spring.datasource.max-Open-Prepared-Statements:10}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.default-Auto-Commit:false}")
    private boolean defaultAutoCommit;

    @Value("${spring.datasource.filters:stat}")
    private String filters;

    /**
     * 当建立新连接时被发送给JDBC驱动的连接参数
     */
    @Value("${spring.datasource.connectionProperties:druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000}")
    private String connectionProperties;

    /**
     * 定义数据源
     * 注意@Primary注解表示：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
     *
     * @return
     * @throws Exception
     */
    @Bean(name = "dataSource")
    @Primary
    @Override
    public DataSource dataSource() throws Exception {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(this.username);
        datasource.setPassword(this.password);
        datasource.setDriverClassName(this.driverClassName);

        datasource.setInitialSize(this.initialSize);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxActive(this.maxActive);
        datasource.setMaxWait(this.maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        datasource.setValidationQuery(this.validationQuery);
        datasource.setTestWhileIdle(this.testWhileIdle);
        datasource.setTestOnBorrow(this.testOnBorrow);
        datasource.setTestOnReturn(this.testOnReturn);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        datasource.setDefaultAutoCommit(this.defaultAutoCommit);
        datasource.setFilters(this.filters);
        datasource.setConnectionProperties(this.connectionProperties);
        return datasource;
    }

    /**
     * 定义session工厂
     * 注：ualifier的意思是合格者，通过这个标示，表明了哪个实现类才是我们所需要的，
     * 我们修改调用代码，添加@Qualifier注解，需要注意的是@Qualifier的参数名称必须为我们之前定义@Service注解的名称之一！
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "sessionFactory")
    @Primary
    @Override
    public SqlSessionFactory sessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        /**MybatisPlus的MybatisSqlSessionFactoryBean,通过这个类才能使用MybatisPlus的BaseMapper**/
        //SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sessionFactory.setMapperLocations(resolver.getResources(MyDruirdConfig.MAPPER));
        return sessionFactory.getObject();
    }

    /**
     * 定义事务管理器
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    @Override
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}