package com.zzz.spider.ipbean;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")

public class IPSpider {

    private final String HTTP_API = "http://www.89ip.cn/tqdl.html?num=60&address=&kill_address=&port=&kill_port=&isp=";
    private final String HTTPS_API = "http://www.89ip.cn/";




    @Test
    public List<IPBean> crawl(){

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //HttpClientParams.setCookiePolicy(httpClient.getParams(), CookiePolicy.BROWSER_COMPATIBILITY);
        List<IPBean> ipList = new ArrayList();
        HttpGet httpGet = new HttpGet(HTTP_API);
        //RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0");
//        httpGet.addHeader("Hm_lpvt_f9e56acddd5155c92b9b5499ff966848","1594118635");
//        httpGet.addHeader("Hm_lvt_f9e56acddd5155c92b9b5499ff966848","1594118380");
//        httpGet.addHeader("waf_cookie","83be4241-6e55-4e9b1c01dd9d976e2882e671f8b7e291d99d");

      //  httpGet.setConfig(defaultConfig);
        CloseableHttpResponse response = null;

        try{
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity);
           // Pattern pattern = Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
           //Pattern pattern = Pattern.compile("\\d\\d\\d.\\d\\d\\d.\\d\\d\\d");
            //Matcher matcher = pattern.matcher(html);
//            int i =0;
//            while (i<10 && matcher.find()){
//                IPBean ipBean = new IPBean();
//                String ip ="ss"; //matcher.group().substring(0,matcher.group().indexOf(":"));
//                String port = "ss";//matcher.group().substring(ip.length()+2,matcher.group().length());
//                System.out.println(html);
//                ipBean.setIp(ip);
//                ipBean.setPort(port);
//                ipList.add(ipBean);
//                i++;
//            }
            Document doc = Jsoup.parse(html);
            Elements elements = doc.select("div.fly-panel");
            String ip_l = elements.select("div").text();
            String ip_s = ip_l.substring(4,500);
            String[] ip = ip_s.split(" ");
            for (int i=0;i<ip.length;i++){
               // System.out.println(ip[i]);
                if(ip[i].length()>0 ){
                String ip_r = ip[i].substring(0,ip[i].indexOf(":"));
                String port = ip[i].substring(ip_r.length()+1,ip[i].length());
                IPBean ipBean = new IPBean();
                ipBean.setIp(ip_r);
                ipBean.setPort(port);
                ipList.add(ipBean);
             }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return ipList;
    }
}
