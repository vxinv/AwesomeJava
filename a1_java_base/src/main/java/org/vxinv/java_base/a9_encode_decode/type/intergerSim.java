package org.vxinv.java_base.a9_encode_decode.type;

public class intergerSim {
    public static void main(String[] args) {
        int i = Integer.parseInt("8F",16);
        System.out.println(i);
        String hexString = Integer.toHexString(6).toUpperCase();
        System.out.println(hexString);
    }
}
