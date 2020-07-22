# sequence-spring-boot-starter

基于SpringBoot autoconfigure 将Snowflake ID生成器做成自动注入服务

## 安装使用

```
mvn install -Dmaven.test.skip=true
```

pom:

```
<dependency>
    <groupId>com.github.sixinyiyu</groupId>
	<artifactId>sequence-spring-boot-starter</artifactId>
    <version>${sequence-spring-boot-starter.version}</version>
</dependency>
```

当前版本：1.0.0.RELEASE

在配置文件中配置

```
sequence.datacenterId=1
sequence.machineId=2
```

最后即可在项目中注解注入 ```ISequenceService``` 接口
