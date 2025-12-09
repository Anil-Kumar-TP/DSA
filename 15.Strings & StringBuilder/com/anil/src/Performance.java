package com.anil.src;

public class Performance {
    public static void main(String[] args) {
        String series = "";
        for (int i = 1; i <= 26; i++){
            char ch = (char) ('A' + i - 1);
            series = series + ch;
        }
        System.out.print(series);
    }
}
