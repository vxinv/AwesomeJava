package org.vxinv.java_base.a9_encode_decode;

import java.nio.charset.StandardCharsets;

/**
 * byte char utf-8
 * 记录 字节数组 hex数组  的转换
 */
public class DataConversion {

    public static void main(String[] args) {
       /* String hello = "hello, 李鑫";
        System.out.println(hello.length());
        byte[] bytes = hello.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        String string = encodeHexString(bytes, 0, bytes.length - 1);
        System.out.println(string);
        System.out.println(string.length());
        String utf = hexStringToString(string);
        System.out.println(utf);*/

        //System.out.println(Arrays.toString(intToByte(125, 2)));
        /*String st = "7";
        String format = String.format("%2s", st).replaceAll(" ", "0");
        System.out.println(format);
        System.out.println(st);

        System.out.println(Arrays.toString(intToByte(2, 2)));

        System.out.println(Integer.toHexString(12345678));

        System.out.println(0x07 & 0xFF);
        System.out.println(0x07 | 0x00);*/

        int a = 0x7F0000F0;
        System.out.println(a | 0xF0);
        System.out.println(a << 4);
    }

    /**
     * 十六进制转字节数组
     *
     * @param hexString
     * @return
     */
    public static byte[] decodeHexString(String hexString) {
        if (hexString.length() % 2 == 1) {
            throw new IllegalArgumentException(
                    "Invalid hexadecimal String supplied.");
        }
        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            bytes[i / 2] = hexToByte(hexString.substring(i, i + 2));
        }
        return bytes;
    }

    /**
     * 十六进制转byte字节
     *
     * @param hexString
     * @return
     */
    public static byte hexToByte(String hexString) {
        int firstDigit = toDigit(hexString.charAt(0));
        int secondDigit = toDigit(hexString.charAt(1));
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    private static int toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if (digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: " + hexChar);
        }
        return digit;
    }

    /**
     * 将int转成byte
     *
     * @param number
     * @param len    字节长度
     * @return
     */
    public static byte[] intToByte(int number, int len) {
        return decodeHexString(intToHex(number, len));
    }

    /**
     * 字节数组 转为十六进制字符串
     *
     * @param byteArray
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String encodeHexString(byte[] byteArray, int startIndex, int endIndex) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = startIndex; i < endIndex + 1; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString().toUpperCase();
    }

    /**
     * 字节转十六进制字符串
     *
     * @param num
     * @return
     */
    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits).toUpperCase();
    }


    /**
     * 16进制转换成为string类型字符串
     *
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, StandardCharsets.UTF_8);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }


    public static String intToHex(int number, int len) {
        String st = Integer.toHexString(number).toUpperCase();
        return String.format("%" + len + "s", st).replaceAll(" ", "0");
    }

}
