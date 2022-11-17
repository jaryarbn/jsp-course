# 部署指南

[![build](https://img.shields.io/github/workflow/status/jaryarbn/jsp-course/Java%20CI%20with%20Maven?label=build&style=flat-square)](https://github.com/jaryarbn/jsp-course/actions/workflows/maven.yml)

- Install Docker and Run MySQL:

```bash
docker run -d -v /path/to:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mini-shop --name=mysql mysql
```

- Or ARM Run：

```bash
docker run -d -v /path/to:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mini-shop --name=mysql arm64v8/mysql
```

- Initialize Database:

```bash
./mvnw flyway:clean flyway:migrate
```

- Optional 1:Run in IntelliJ IDEA.


- Optional 2:Run with docker.
    - Run Tomcat container and wait the containers started:
      ```bash
      docker run -d -p 8080:8080 tomcat
      ```

    - Generate the war package and put it in `/webapps` directory:
      ```bash
      ./mvmw package
      ```
      ```bash
      mv
      ```

    - Then access `http://localhost:8080`.
