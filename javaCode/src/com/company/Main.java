package com.company;
//import com.company.Solution;

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"};

        System.out.println(minMutation(start, end, bank));

    }

    public static int minMutation(String start, String end, String[] bank) {
        StringBuffer sb_start = new StringBuffer(start);
        StringBuffer sb_end = new StringBuffer(end);
        HashSet<String> hashSet = new HashSet<>();
        int count = 0;
        char origin_ch;

        if (start.equals(end)) {
            return 0;
        }

        for (int i = 0; i < bank.length; i++) {
            hashSet.add(bank[i]);
        }

        if (!hashSet.contains(end)) {
            return -1;
        }


        while (!sb_start.toString().equals(sb_end.toString())) {
            StringBuffer tmp = new StringBuffer(sb_start);

            for (int i = 0; i < 8; i++) {
                if (sb_start.charAt(i) == sb_end.charAt(i)) {
                    continue;
                } else {
                    origin_ch = tmp.charAt(i);
                    sb_start.setCharAt(i, sb_end.charAt(i));
                    String st_start = new String(sb_start);
                    if (hashSet.contains(st_start)) {
                        count++;
                    } else {
                        sb_start.setCharAt(i, origin_ch);
                    }
                }
            }
            if (tmp.toString().equals(sb_start.toString())) {
                return -1;
            }
        }
        return count;
    }
}
