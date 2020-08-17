package org.example;

import cn.hutool.extra.ssh.Sftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class XFTPUtil {

    public static void main(String[] args) {

        File configPath = FilePathUtil.getConfigPath("config.properties");
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(configPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String outpath = properties.getProperty("outpath");
        File outPath = new File(outpath);
        Sftp ftp = new Sftp("192.168.0.252", 22, "root", "admin123");
        ftp.download("/var/lib/jenkins/workspace/dev-test（更新代码重启）内网-逻辑-服务器/game_server_develop/bootstrap/target/server-local.tar", outPath);
        ftp.close();
        System.exit(0);
    }
}
