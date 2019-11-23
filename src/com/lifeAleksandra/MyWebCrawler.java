package com.lifeAleksandra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyWebCrawler {

    public static Queue<String> queue = new LinkedList<>();
    public static Set<String> marked = new HashSet<>();
    public static String regex = "(/site/red/).*"; //pattern of URL (\w+\.)*(\w+)

    //alghoritm metod
    public static void bfsAlghoritm(String root) throws IOException {
        queue.add(root);
        BufferedReader br = null;

        while (!queue.isEmpty()) {
            String crawledUrl = queue.poll();
//            String[] crawledUrl2 = crawledUrl1.split("\" ");
//            String crawledUrl3 = crawledUrl2[0];
//            String crawledUrl = new StringBuilder("https://www.skapiec.pl").append(crawledUrl3).toString();



            System.out.println("Site crawled: " + crawledUrl);

            //limit to 10 websides

            if (marked.size() > 10)
                return;

            boolean ok = false;
            URL url = null;


            while (!ok) {
                try {

                    url = new URL(crawledUrl);
                    br = new BufferedReader(new InputStreamReader(url.openStream()));
                    ok = true;
                } catch (MalformedURLException e) {
                    System.out.println("Malformed url: " + crawledUrl);
                    crawledUrl = queue.poll();
                    ok = false;
                } catch (IOException ioe) {
                    System.out.println("IOException url: " + crawledUrl);
                    crawledUrl = queue.poll();
                    ok = false;
                }

                StringBuilder sb = new StringBuilder();

                while ((crawledUrl = br.readLine()) != null) {
                    sb.append(crawledUrl);
                }
                crawledUrl = sb.toString();
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(crawledUrl);

                while (matcher.find()) {
                    String w1 = matcher.group();
                    String[] w2 = w1.split("\" ");
                    String w3 = w2[0];
                    String w = new StringBuilder("https://www.skapiec.pl").append(w3).toString();

                    if (!marked.contains(w)) {
                        marked.add(w);
                        System.out.println("Sites added: " + w);
                        queue.add(w);
                    }
                }
            }
            if (br != null) {
                br.close();
            }
        }
    }
    public static void showResults(){
            System.out.println("\n\nResults:");
            System.out.println("Web sites crowled: " + marked.size() + "\n");

            for(String s : marked){
                System.out.println("* " + s);
            }
        }

    public static void main(String[] args) {
        try {
            bfsAlghoritm("https://www.skapiec.pl/site/cat/52/comp/10076187"); //"https://www.ssaurel.com/blog"
            showResults();
        } catch (IOException e) {
        }
    }
    }


