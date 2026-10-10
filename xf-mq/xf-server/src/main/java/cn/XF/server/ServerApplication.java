package cn.XF.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>数据分析服务</p>
 *
 * @author cz
 **/
@SpringBootApplication
public class ServerApplication {
    private static final Logger logger = LoggerFactory.getLogger(ServerApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerApplication.class).web(WebApplicationType.NONE).run(args);
        logger.info("启动成功！！");
    }
}
