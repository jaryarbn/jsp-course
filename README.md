# 部署指南
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
