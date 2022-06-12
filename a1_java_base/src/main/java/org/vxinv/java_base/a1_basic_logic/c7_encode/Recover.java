package org.vxinv.java_base.a1_basic_logic.c7_encode;


import java.io.UnsupportedEncodingException;

public class Recover {

    public static void recover(String str) throws UnsupportedEncodingException {
        String[] charsets = new String[]{"windows-1252", "GB18030", "Big5", "UTF-8"};
        for (int i = 0; i < charsets.length; i++) {
            for (int j = 0; j < charsets.length; j++) {
                if (i != j) {
                    String s = new String(str.getBytes(charsets[i]), charsets[j]);
                    System.out.println("---- 原来编码(A)假设是: " + charsets[j] + ", 被错误解读为了(B): " + charsets[i]);
                    System.out.println(s);
                    System.out.println();
                }
            }
        }
    }

    public static void writeAscii(){
        System.out.println((char)0x07);
        System.out.println('\u0038');
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "ÀÏÂíhaha";
        String str2= "您好,世界";
        try {
             // recover(str2);
            writeAscii();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
