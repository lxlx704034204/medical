ps -ef | grep LongConnection-1.0-SNAPSHOT | grep -v grep | cut -c 9-15 | xargs kill -s 9 > /dev/null 2>&1
nohup java -cp LongConnection-1.0-SNAPSHOT-jar-with-dependencies.jar netty.NettyServerBootstrap > LongConnectionService.log 2>&1 &
