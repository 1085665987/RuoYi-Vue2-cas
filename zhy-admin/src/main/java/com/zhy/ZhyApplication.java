package com.zhy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author zhy
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ZhyApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ZhyApplication.class, args);
        System.out.println("          智洋启动成功\n" +
                " ######## ##     ## ##    ##  \n" +
                "      ##  ##     ##  ##  ##   \n" +
                "     ##   ##     ##   ####    \n" +
                "    ##    #########    ##     \n" +
                "   ##     ##     ##    ##     \n" +
                "  ##      ##     ##    ##     \n" +
                " ######## ##     ##    ##     \n");
    }
}
