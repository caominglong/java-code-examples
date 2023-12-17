### J2EE中JDBC的技术发展历程
JDBC -> DBUtils(QueryRunner) -> JdbcTemplate -> 框架

框架是一个整体解决方案：
如果进行事务控制
如果进行查询缓存

数据操作步骤：
编写sql -> 预编译 -> 设置参数 -> 执行sql -> 封装结果

hibernate：
全自动的orm框架
目的：旨在消除sql
缺点：
自定义sql麻烦。需要学习新的语言：HQL
加重学习负担

希望：sql语句由开发人员编写，希望sql不失去灵活性

引出了Mybatis

### Mybatis
概念：是一个轻量级的半自动orm框架
下载地址：https://github.com/mybatis/mybatis-3/
设计原理：sql与java编码分离，由开发人员控制
只需要掌握sql就行

第一个helloworld：
先下载mybatis依赖包


关键类与关键原理：
SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
SqlSession openSession = sqlSessionFactory.openSession();
原理：创建接口的代理类，使用SqlSession来操作数据库

1、接口式编程
原生：Dao => DaoImpl
MyBatis： Mapper => xxMapper.xml
2、SqlSession代表与数据库的一次会话，用完就释放。与Connection一样，
是非线程安全的。每次使用都应该获取新的对象
3、Mapper接口没有实现类，MyBatis会为Mapper创建一个代理对象
// 将mapper与xml文件关联起来
EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
4、两个重要的配置文件
（1）Mybatis的全局配置文件，包含数据库连接池信息，事务管理器信息等
（2）sql映射文件，必须要有，保存了sql语句的映射信息

### Mybatis的全局配置文件
// 引入外部properties配置文件内容
// resource：引入类路径下资源
// url:网络路径或磁盘路径
<properties></properties>

// 设置项（很重要）
// mapUnderscoreToCamelCase是否开启驼峰映射
<settings>
    <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>

// 别名处理器，可以为java处理器起别名
<typeAliases></typeAliases>

// 类型处理器
<typeHandlers></typeHandlers>
自定义类型处理器
（1）实现org.apache.ibatis.type.TypeHandler接口或者继承org.apache.ibatis.type.BaseTypeHandler
（2）指定其映射某个JDBC类型（可选操作）
（3）在Mybatis全局配置文件中注册

// 利用插件来拦截sql语句的执行步骤
// 四大对象
// Executor
// ParameterHandler
// ResultSetHandler
// StatementHandler
<plugins>
    <plugin interceptor=""></plugin>
</plugins>

// 环境配置
//default表示当前是什么环境
<environments default="">
        <environment id="">
            <transactionManager type=""></transactionManager>
            <dataSource type=""></dataSource>
        </environment>
    </environments>

// 支持多数据库厂商
// 在sql语句下可以通过databaseId来设置
<databaseIdProvider type=""></databaseIdProvider>

<!-- 5、databaseIdProvider：支持多数据库厂商的；
 type="DB_VENDOR"：VendorDatabaseIdProvider
    作用就是得到数据库厂商的标识(驱动getDatabaseProductName())，mybatis就能根据数据库厂商标识来执行不同的sql;
    MySQL，Oracle，SQL Server,xxxx
-->
作用：可以结合environments标签来配置不同的数据库的环境


