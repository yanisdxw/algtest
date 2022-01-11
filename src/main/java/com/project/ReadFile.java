package com.project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) {
        new ReadFile().demo();
    }

    private void demo(){
        String localPath = System.getProperty("user.dir");
        System.out.println("当前localPath："+localPath);
        List<String> data = read1(localPath+File.separator+"data.txt");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }

    // File-->FileInputStream-->InputStreamReader-->BufferedReader
    // bf.readLine()
    private List<String> read1(String name){
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File file = new File(name);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
