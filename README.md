# userSign 获取服务

##### 修改配置
application.properties文件中三个配置项的实际值

##### 服务部署
- 打包命令：mvn clean install
- 启动命令：nohup java -jar video-service.jar  >> video.log 2>&1 &

##### 请求示例
- http://ip:port/video-service/getSign?userId=zhangsan


注意
- 
- java中使用的公私钥必须是pkcs8格式，而腾讯云控制台下载公私钥格式是非pkcs8格式需要进行转化，转化方式见链接https://blog.csdn.net/duan19056/article/details/52104966