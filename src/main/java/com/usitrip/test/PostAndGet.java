package com.usitrip.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.internal.util.xml.impl.Input;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

public class PostAndGet {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36";
    private static final String URL = "http://www.mafengwo.cn/mdd/base/list/pagedata_citylist";
    private static final String FILEPATH = "C:/Users/vivian.xia/Desktop/采集的数据/trafic/uscanadacity.txt";

    public static void main(String[] args) throws Exception {
        String[] pages = new String[]{"15","2","0","1","1","1","1","0","0","1","0","0","0","1","3","1",
                "2","22","1","1","2","1","2","4","1","1","1","0","1","1","2","0","2","1","1","2","1","1","4","1","2",
                "1","0","1","1","1","2","0","1","4","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","1",
                "1","0","1","1","2","5","2","41","31","2","14","25","4","13","3","1","1","2","2","13","5","2","10","1",
                "1","1","2","7","1","1","1","2","6","0","7","1","8","4","0","71","11","29","9","9","1","6","5","5","1","11",
                "1","2","11","3","3","1","1","0","1","1","5","4","2","8","1","10","2","3","1","0","0","0","2","2","16","2","52",
                "21","4","1","5","1","2","1","2","1","2","2","1","1","422","8","2","13","19","3","5","1","2","2","2","1","2",
                "1","1","13","1","5","2","39","6","5","3","3","9","9","2","3","1","1","4","1","20","2","2","10","1","1","1","1","1","1","3","1","2","2"};
        String[] countyIds = new String[]{"10544","52088","57164","17753","24406","54998","15911","57168","57166","57163","57162","57167","57161","19016",
                "11044","10344","12647","10202","10689","28359","11751","57186","12034","11604","10818","57185","15123","57184","32925","16827","12026",
                "57183","21111","12027","19955","10455","10762","11753","12033","18450","11761","12036","29615","17439","57182","22478","16746","57181",
                "57180","10029","13122","57179","27636","11752","57178","11706","57177","32815","57176","57175","12031","57174","57173","19760","17958",
                "57172","57171","56531","15534","57170","22047","12858","10178","12032","10122","10051","11094","10168","10173","15693","10053","11852",
                "11153","15077","16648","26909","10169","10214","10172","11160","11140","24945","38921","16501","30071","11098","11097","18942","18897",
                "11853","57193","10174","57192","11099","10448","11614","10171","10300","10176","11157","11147","11570","10549","11105","38605","28072","10175",
                "19744","11631","11131","24844","10992","12104","15757","36914","57187","10955","18225","13484","11005","10160","38471","10159","12030","17493",
                "57160","57159","57158","57157","57156","57155","11656","31459","10062","10177","30877","12029","11684","57154","24412","57153","25756","32796",
                "25229","11943","57152","57151","21536","10180","11221","10181","10182","10605","11699","28466","21498","32160","11217","10754","48878","10753",
                "35250","10083","24254","11058","11765","10183","10069","10179","14783","14293","10097","10101","12028","10820","21762","12035","10070","57194",
                "10184","17393","10234","10067","29700","11780","10711","15519","32105","11697","31369","16674","11213","11698"};

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(URL);

        Pattern pattern = Pattern.compile("data-id=\\\\\"[\\d]+\\\\\">");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < countyIds.length; i++) {
            if (countyIds[i].equals("10062") || countyIds[i].equals("10177")) {
                int page = Integer.parseInt(pages[i]);
                if (page > 0) {
                    for (int j = 1; j <= page; j++) {
                        String s = sendPost(client, post, countyIds[i], String.valueOf(j));
                        parseResponse(s, pattern, sb);
                        Thread.sleep(800);
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(FILEPATH)));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        System.out.println(sb.toString());
    }

    // HTTP POST request
    private static String sendPost(HttpClient client, HttpPost post, String countryId, String page) throws Exception {
        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("mddid", countryId));
        urlParameters.add(new BasicNameValuePair("page", page));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        return result.toString();
    }

    public static void parseResponse(String s, Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String s1 = matcher.group();
            sb.append("http://www.mafengwo.cn/travel-scenic-spot/mafengwo/" + s1.substring(s1.indexOf("\"") + 1, s1.lastIndexOf("\\")) + ".html\r\n");
        }
    }

    @Test
    public void test1() {
        String str  = "626 688 1059  949 501 5147  95040412981  16266881059";
//        Pattern compile = Pattern.compile("\\b[\\d]{3}\\s?[\\d]{3}\\s?[\\d]{4}\\b");
        Pattern compile = Pattern.compile("[\\d]{3}");
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
