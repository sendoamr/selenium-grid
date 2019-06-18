##### 1. Launch Grid navidators
```
docker-compose up
```

##### 2. Change feature ip by local ip
##### 3. Complete the driver Setup and SeleniumGridPage
##### 4. Launch the test with different navigators
```
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
```
##### 5. See complete report in home-page-html

##### 6. Launch with different resolutions
 ```
 mvn clean test -Dbrowser=chrome -Dwidth=1024 -Dheight=800
 ```
