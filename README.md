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

## Managment
To see administration console open: http://{ip-machine}:4444/grid/console

## Scale navigator
For example for launch 5 instances of chrome:
```
docker-compose scale chrome=5
```