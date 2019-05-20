### Launch Grid navidators and firefox
```
docker-compose -f docker-compose-firefox.yml up
```

### Launch Grid navidators and chrome
```
docker-compose -f docker-compose-chrome.yml up
```

### Launch Grid navidators
```
docker-compose up
```
It starts a grid in http://{local ip}:4444/wd/hub/
Run in local mvn clean install -Durl=https://locahost:8080/ -Dbrowser=Chrome -Dwidth=1024 -DHeight=900


## Managment
To see administration console open: http://{ip-machine}:4444/grid/console