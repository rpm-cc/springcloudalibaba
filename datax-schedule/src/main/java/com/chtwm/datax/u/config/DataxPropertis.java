package com.chtwm.datax.u.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Piming Ren
 * @date: 2021/6/2 09:10
 * @version: 1.0
 * @description: datax 同步条件的设置 。可以进行扩展。
 */
@Configuration
@ConfigurationProperties(prefix = "datax.run")
public class DataxPropertis {
    /**
     * datax 启动 datax.py的目录
     */
    private String path;
    /**
     * datax job json 文件地址
     */
    private String jobid;

    private Params params = new Params();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    @Configuration
    @ConfigurationProperties(prefix = "datax.run.params")
    public class Params {
        /**
         * 用来更新的时间。用于增量更新
         */
        private String lastTime;
        /**
         * currentTime
         */
        private String currentTime;
        /**
         * 源数据链接地址。可以是多个，使用‘，’分割
         */
        private String readerJdbcUrl;
        /**
         * 源数据库用户名称
         */
        private String readerUsername;
        /**
         * 源数据库用户密码
         */
        private String readerPassword;
        /**
         * 目标数据库链接地址，
         */
        private String writerJdbcUrl;
        /**
         * 目标数据库用户名称
         */
        private String writerUsername;
        /**
         * 目标数据库用户密码
         */
        private String writerPassword;

        public String getLastTime() {
            return lastTime;
        }

        public void setLastTime(String lastTime) {
            this.lastTime = lastTime;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public String getReaderJdbcUrl() {
            return readerJdbcUrl;
        }

        public void setReaderJdbcUrl(String readerJdbcUrl) {
            this.readerJdbcUrl = readerJdbcUrl;
        }

        public String getReaderUsername() {
            return readerUsername;
        }

        public void setReaderUsername(String readerUsername) {
            this.readerUsername = readerUsername;
        }

        public String getReaderPassword() {
            return readerPassword;
        }

        public void setReaderPassword(String readerPassword) {
            this.readerPassword = readerPassword;
        }

        public String getWriterJdbcUrl() {
            return writerJdbcUrl;
        }

        public void setWriterJdbcUrl(String writerJdbcUrl) {
            this.writerJdbcUrl = writerJdbcUrl;
        }

        public String getWriterUsername() {
            return writerUsername;
        }

        public void setWriterUsername(String writerUsername) {
            this.writerUsername = writerUsername;
        }

        public String getWriterPassword() {
            return writerPassword;
        }

        public void setWriterPassword(String writerPassword) {
            this.writerPassword = writerPassword;
        }

        /**
         * 将所有获得的参数，组装成datax 运行需要的参数
         *
         * @return
         */
        public String convertParams() {

            return "  -Dlast_time=" + lastTime +
                    " -Dcurrent_time=" + currentTime +
                    " -Dreader_jdbcUrl=" + readerJdbcUrl +
                    " -Dreader_username=" + readerUsername +
                    " -Dreader_password=" + readerPassword +
                    " -Dwriter_jdbcUrl=" + writerJdbcUrl +
                    " -Dwriter_username=" + writerUsername +
                    " -Dwriter_password=" + writerPassword;

        }
    }
}
