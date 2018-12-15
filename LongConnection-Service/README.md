#启动服务端程序，如：startLongConnectionService.sh
java -cp LongConnection-1.0-SNAPSHOT-jar-with-dependencies.jar netty.NettyServerBootstrap

nohup java -cp LongConnection-1.0-SNAPSHOT-jar-with-dependencies.jar netty.NettyServerBootstrap > LongConnectionService.log 2>&1 &

#启动客户端程序
java -cp LongConnection-1.0-SNAPSHOT-jar-with-dependencies.jar netty.NettyClientBootstrap

#模拟第三方接口调用升级命令给客户端升级
java -cp LongConnection-1.0-SNAPSHOT-jar-with-dependencies.jar netty.SendOrderNettyClient

#清除日志文件的内容 如：clearLongConnectionServerLog.sh
echo "" > LongConnectionService.log
