package org.vxinv.java_base.a9_encode_decode;

public class ByteToInt {
    public static void main(String[] args) {
        //int value = bytes.getInt(2,4); //This method doesn't exist
        //splitBigByte( 0xBB0D8196);
        getDoubleShort(3276);
        System.out.println(Short.MAX_VALUE);
        System.out.println(35*0.01F);
    }

    // 高字节在后  低字节在前
    public static void splitBigByte(int ri) {
        // 从低到高
        byte b3 = (byte) (ri & 0xff);
        byte b2 = (byte) ((ri & 0xff00) >> 8);
        byte b1 = (byte) ((ri & 0xff0000) >> 16);
        byte b0 = (byte) ((ri & 0xff000000) >> 24);

        // 高字节在前 低字节在后
        int realInt = (b0 & 0xff) << 0 | (b1 & 0xff) << 8 | (b2 & 0xff) << 16 | (b3 & 0xff) << 24;
        System.out.printf("%x\n", realInt);


    }

    public static void getDoubleShort(int ri) {
        // 获取低八位
        byte r1 = (byte) (ri & 0xff);
        // 获取高八位
        byte r2 = (byte) ((ri & 0xff00) >> 8);
        short realS = (short) (r1 & 0xff | ((r2 & 0xff) << 8));
        System.out.println(realS);
    }


}
