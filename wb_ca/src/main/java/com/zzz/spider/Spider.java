package com.zzz.spider;

import com.zzz.spider.ipbean.IPBean;
import com.zzz.spider.ipbean.IPSpider;
import com.zzz.spider.util.ProxyUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Spider {
    private static final String url = "http://weibo.cn/comment/J6hVIt5j8?uid=1792951112&";
    private static final Logger logger = LoggerFactory.getLogger(Spider.class);
   
   private static final String cookies = "{cookies}";
 
    @Test
    public void getData(int pages,IPBean ipBean) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        String URL = url + "page=" + pages;
        HttpGet httpGet = new HttpGet(URL);
        HttpHost httpHost = new HttpHost(ipBean.getIp(),Integer.parseInt(ipBean.getPort()));
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0");
         httpGet.addHeader("Cookie", cookies);
		 /**
		 *
		 *
		 键值对的方式加cookie，为保护个人隐私cookie已做处理
		 **/
        httpGet.addHeader("_T_WM", "f095902252ad9becd424bebc76");
        httpGet.addHeader("SUB", "_2A25eFP6VoV8SzFyDSIHXVRCl9nrDV6PUJbkdANLRjXkW1NQT8ronBeJYGOMVminRGWwFvRi4yCh95T");
        httpGet.addHeader("SUHB", "031Ha");
        httpGet.addHeader("SCF", "AnoHK7Jpqx8bCdOk4HkEwDJMTTBxpHeVj9QFMsFU6Xe-QQ_FSU0cjZoIwykLqFxdMskUu4a-0Yl9MkeElgw.");
        httpGet.addHeader("SSOLoginState", "15947");
        RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setConnectTimeout(10000).setConnectionRequestTimeout(10000).build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() != 200) {
                System.out.println(statusLine.getStatusCode());

            } else {
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    System.out.println("null");
                }
                String html = EntityUtils.toString(entity);
                parser(html,ipBean);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void parser(String html,IPBean ipBean) {

        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("div.c[id]");
        for (Element item : elements) {
            String comment = "";
            String username = "";
            String a = "";
            String phone = "";
            String ainfo = "";
            StringBuilder stringBuilder = new StringBuilder();
            try {
                a = "https://weibo.cn" + item.select("div.c > a").first().attr("href");//用户的信息页面链接
                comment = item.select("span.ctt").text();
                username = item.select("div.c > a").first().text();
                String a_info = a.substring(1, a.indexOf("u"));
                ainfo = a.substring(a_info.length() + 2, a.length());//拼接成真正的用户信息页面链接
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            } catch (NullPointerException e) {
                continue;
            }
            String gender = "";
            String brithday = "";
            //logger.info(stringBuilder.toString());
            CloseableHttpClient httpClient1 = HttpClientBuilder.create().build();
            CloseableHttpClient httpClient2 = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(a);
            HttpHost httpHost = new HttpHost(ipBean.getIp(),Integer.parseInt(ipBean.getPort()));
            HttpGet httpGet1 = new HttpGet("https://weibo.cn" + ainfo + "/info");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20100101 Firefox/77");
           /**
		   *
		   *
		   键值对的方式加cookie，为保护个人隐私cookie已做处理
		   **/
            httpGet.addHeader("_T_WM", "f095902252ad9becd424bebc76");
            httpGet.addHeader("SUB", "_2A25eFP6VoV8SzFyDSIHXVRCl9nrDV6PUJbkdANLRjXkW1NQT8ronBeJYGOMVminRGWwFvRi4yCh95T");
            httpGet.addHeader("SUHB", "031Ha");
            httpGet.addHeader("SCF", "FMsFU6Xe-QQ_FSU0cjZoIwykLqFxdMskUu4a-0Yl9MkeElgw.");
            httpGet.addHeader("SSOLoginState", "19967");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20100101 Firefox/77");
            
            httpGet.addHeader("_T_WM", "f095052ad9becd424bebc76");
            httpGet.addHeader("SUB", "2A25eFP6VoV8SzFyDSIHXVRCl9nrDV6PUJbkdANLRjXkW1NQT8ronBeJYGOMVminRGWwFvRi4yCh95T");
            httpGet.addHeader("SUHB", "031Ha");
            httpGet.addHeader("SCF", "FMsFU6Xe-QQ_FSU0cjZoIwykLqFxdMskUu4a-0Yl9MkeElgw.");
            httpGet.addHeader("SSOLoginState", "19967");
//            RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setConnectTimeout(10000).setConnectionRequestTimeout(10000).build();
//            httpGet.setConfig(requestConfig);
//            httpGet1.setConfig(requestConfig);
            CloseableHttpResponse response = null;
            CloseableHttpResponse response1;
            try {
                response = httpClient1.execute(httpHost,httpGet);
                response1 = httpClient2.execute(httpHost,httpGet1);
                StatusLine statusLine = response.getStatusLine();
                StatusLine statusLine1 = response1.getStatusLine();
                if (statusLine.getStatusCode() != 200 && statusLine1.getStatusCode() != 200) {
                    return;
                } else {
                    HttpEntity entity = response.getEntity();
                    HttpEntity entity1 = response1.getEntity();
                    if (entity == null && entity1 == null) {
                        System.out.println("null");
                    } else {
                        String html1 = EntityUtils.toString(entity);
                        Document document = Jsoup.parse(html1);
                        phone = document.select("div.c[id]").first().select("span.ct").text();
                        String html2 = EntityUtils.toString(entity1);
                        Document document1 = Jsoup.parse(html2);
                        String gender1 = document1.select("div.c").next().next().text();
                        Pattern pattern = Pattern.compile("性别:(.)");
                        Matcher matcher = pattern.matcher(gender1);
                        gender = matcher.find() ? matcher.group() : "0";
                        Pattern pattern1 = Pattern.compile("生日:(\\d{4})");
                        Matcher matcher1 = pattern1.matcher(gender1);
                        brithday = matcher1.find() ? matcher1.group() : "0";
                    }
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } finally {
                if (response != null) {
                    try {
                        response.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            stringBuilder.append(username + ",").append(comment).append("," + phone).append("," + gender).append("," + brithday);

            logger.info(stringBuilder.toString());
        }
    }

    public static void main(String[] args) {
        final IPSpider ipSpider = new IPSpider();
        final ProxyUtils proxyUtils = new ProxyUtils();
        Timer time = new Timer();
        Calendar calendar = Calendar.getInstance();
        Date firstTime = calendar.getTime();
        final Spider spider = new Spider();
        // 间隔：2分钟
        long period = 1000 * 60 * 5;
        final IPBean bean = new IPBean();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 执行你的方法
                list = ipSpider.crawl();
                IPBean bean = list.get(24);
               proxyUtils.setGlobalProxy(bean);

				for (int i = 1; i < 100001; i++) {
					spider.getData(i,bean);
				}

            }
        }, firstTime, period);
    }
}