ps -ef | grep bedcard-service-1.0-SNAPSHOT.jar | grep -v grep | cut -c 9-15 | xargs kill -s 9 > /dev/null 2>&1
nohup java -jar bedcard-service-1.0-SNAPSHOT.jar > logs/bedcard-service.log 2>&1 &

