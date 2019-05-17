package com.dxw.Trie;

import com.dxw.set.BSTSet;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            String filename= RandomStringUtils.randomAlphanumeric(1);
            words.add(filename);
        }

        long startTime = System.nanoTime();
        BSTSet<String> set = new BSTSet<>();
        for(String word:words){
            set.add(word);
        }
        for(String word:words){
            set.contains(word);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime)/1000000000.0;
        System.out.println("BSTSet: "+time+"s");

        startTime = System.nanoTime();
        Trie trieSet = new Trie();
        for(String word:words){
            trieSet.add(word);
        }
        for(String word:words){
            trieSet.contains(word);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime)/1000000000.0;
        System.out.println("TrieSet: "+time+"s");
    }
}
