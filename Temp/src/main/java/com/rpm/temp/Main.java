package com.rpm.temp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Piming Ren
 * @date: 2021/9/9 14:48
 * @version: 1.0
 * @description:
 */
public class Main {


    public static void main(String[] args) {

      String a  = "11111";
      String b = "15111";
        System.out.println(safeEqual(a,b));
    }


   static boolean safeEqual(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        int equal = 0;
        for (int i = 0; i < a.length(); i++) {
            int c = a.charAt(i) ^ b.charAt(i);
            equal |= c;
        }
        return equal == 0;
    }
}
