package com.zzz.spider.ipbean;

public class IPBean {
    public static final int TYPE_HTTP = 0;
    public static final int TYPE_HTTPS = 1;

    private String ip;
    private String port;


    public IPBean(IPBean bean){
        ip = bean.getIp();
        port = bean.getPort();

    }

    public IPBean() {
        this.ip = ip;
        this.port = port;

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


}
