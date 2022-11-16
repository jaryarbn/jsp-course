# 部署指南
[![build](https://img.shields.io/github/workflow/status/jaryarbn/jsp-course/Java%20CI%20with%20Maven?label=build&style=flat-square)](https://github.com/jaryarbn/jsp-course/actions/workflows/maven.yml)
- Install Docker and Run:
```
docker run -d -v /path/to:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mini-shop --name=mysql mysql
```
- Or M1 Run：
``` 
docker run -d -v /path/to:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mini-shop --name=mysql arm64v8/mysql
```

- Then Initialize Database:
```
./mvnw flyway:clean flyway:migrate
```
