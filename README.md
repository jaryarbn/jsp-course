# 部署指南

[![build](https://img.shields.io/github/workflow/status/jaryarbn/jsp-course/Java%20CI%20with%20Maven?label=build&style=flat-square)](https://github.com/jaryarbn/jsp-course/actions/workflows/maven.yml)

- Install Docker and Run MySQL:

```bash
docker run -d -v `pwd`/shop-data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mini-shop --name=mysql mysql
```

- Or ARM Run：

```bash
docker run -d -v `pwd`/shop-data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mini-shop --name=mysql arm64v8/mysql
```

- Initialize Database:

```bash
./mvnw flyway:clean flyway:migrate
```
**注意，如果你使用的是Windows，将所有的./mvnw换成./mvnw.cmd**


- Optional 1: Run in IntelliJ IDEA Ultimate or another IDE that you can run.


- Optional 2: Run with docker.
    - Run Tomcat container and wait the containers started:
      ```bash
      docker run -d -p 8080:8080 tomcat
      ```

    - Generate the war package and put it in `/webapps` directory:
      ```bash
      ./mvnw clean package
      ```
      ```bash
      mv ./target/jsp-course-1.0-SNAPSHOT.war
      ```
    - Then access `http://localhost:8080`.
# 实现功能
- 用户注册
  - 验证码
- 用户登录
  - 记住密码
  - 注销
- 购物车
  - 添加商品
  - 删除商品
  - 清空购物车
- 订单
  - 生成订单
  - 查看历史订单
  - 查看订单详情
