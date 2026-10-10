package cn.XF.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * <p>对接客户接收端服务</p>
 *
 * @author cz
 **/
@SpringBootApplication
public class ClientApplication {
    private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClientApplication.class);
        Environment env = app.run(args).getEnvironment();
        logger.info("启动成功！！");
        logger.info("队列接收客户端地址: http://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
