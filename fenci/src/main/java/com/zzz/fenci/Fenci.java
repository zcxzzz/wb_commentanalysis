package com.zzz.fenci;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.nlpcn.commons.lang.util.WordWeight;

import java.io.*;
import java.util.*;

public class Fenci {
    private static String content = null;
    @Test
    public void getfile(){
        File file = new File("filepath");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = reader.readLine()) != null){
                content += str;
            }
            fenci1(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<String, Double> wordCount(List<String> words) {
        WordWeight ww = new WordWeight();
        for (String word : words) {
            ww.add(word);
        }
        return ww.export();
    }
    public List<Word> fenci1(String str){
        Set<String> expectedNature = new HashSet<String>() {{
            add("n");add("v");add("vd");add("vn");add("vf");
            add("vx");add("vi");add("vl");add("vg");
            add("nt");add("nz");add("nw");add("nl");
            add("ng");add("userDefine");add("wh");
        }};
        Result result = ToAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms
//        System.out.println(result.getTerms());
//
        List<Term> terms = result.getTerms(); //拿到terms
//        System.out.println(terms.size());
        List<String> words = new ArrayList<String>();
        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            String natureStr = terms.get(i).getNatureStr(); //拿到词性
            if(expectedNature.contains(natureStr)) {
//                System.out.println(word + ":" + natureStr);
                words.add(word);
            }
        }
        Map<String, Double>  map = wordCount(words);
        List<Word> tongji = new ArrayList<Word>();
        int i =1;
        for(Map.Entry<String,Double> entry : map.entrySet()){
            if(entry.getValue()/map.size() > 0.1){
                i ++;
                Word word = new Word();
                word.setWords(entry.getKey());
                word.setPinglv(entry.getValue());
                tongji.add(word);
                System.out.println(entry.getKey()+":"+entry.getValue()/map.size());
            }
        }System.out.println(i);
        return tongji;
    }


}
