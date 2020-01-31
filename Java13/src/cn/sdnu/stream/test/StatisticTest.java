package cn.sdnu.stream.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Master_Joe qiaoguangtong@aliyun.com
 * @create 8:03 PM
 */
public class StatisticTest {

    @Test
    public void test1() {
        BufferedReader br = null;
        Map<Character, Integer> map = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader("English.txt"));
//            String str = "";
//            while ((str = br.readLine()) != null) {
//                for (int i = 0; i < str.length(); i++) {
//                    char c = str.charAt(i);
//                    if (map.containsKey(c)) {
//                        map.put(c, map.get(c) + 1);
//                    } else {
//                        map.put(c, 1);
//                    }
//                }
//            }
            int len;
            while ((len = br.read()) != -1) {
                char c = (char) len;
//                if (map.get(c) == null) {
//                    map.put(c, 1);
//                } else {
//                    map.put(c, map.get(c) + 1);
//                }
                // since 1.8
                map.merge(c, 1, Integer::sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("Map.txt"));

            Set<Character> characters = map.keySet();
            for (Character c : characters) {
                bw.write(c + "的数量是" + map.get(c));
                // System.out.println();
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
