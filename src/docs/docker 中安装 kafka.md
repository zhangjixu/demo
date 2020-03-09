# docker 中安装 kafka
```json
使用 MacDown 软件打开
```
## docker 中加速器配置
```
在 /etc/docker/daemon.json 文件中配置以下内容
{
  "registry-mirrors" : [
    "http://ovfftd6p.mirror.aliyuncs.com",
    "http://registry.docker-cn.com",
    "http://docker.mirrors.ustc.edu.cn",
    "http://hub-mirror.c.163.com"
  ],
  "insecure-registries" : [
    "registry.docker-cn.com",
    "docker.mirrors.ustc.edu.cn"
  ],
  "debug" : true,
  "experimental" : true
}

配置完成后执行以下命令
systemctl daemon-reload
systemctl restart docker

```
## docker 安装 kafka 流程
[链接](https://blog.csdn.net/qq_35394891/article/details/84349955)

```

另一个链接
https://www.jianshu.com/p/7635ea96e53f

docker pull wurstmeister/zookeeper  
docker pull wurstmeister/kafka

启动zookeeper
docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper  

启动kafka
docker run -d --name kafka --publish 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 --env KAFKA_ADVERTISED_HOST_NAME=192.168.0.10 --env KAFKA_ADVERTISED_PORT=9092 wurstmeister/zookeeper
进入容器内部
docker exec -it kafka /bin/bash 

进入kafka默认目录
cd /opt/kafka_2.12-2.1.0/bin

创建一个主题：
./kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic test_zjx

运行一个消息生产者，指定topic为刚刚创建的主题
./kafka-console-producer.sh --broker-list 自己机器ip:9092 --topic test_zjx 

运行一个消费者，指定同样的主题
./kafka-console-consumer.sh --bootstrap-server 自机器ip:9092 --topic test_zjx --from-beginning
```