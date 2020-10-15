package com.example.demo;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 功能描述: 这里注意二进制转十六进制，十六进制转二进制的必要性

 * @version 2.4.0
 * @Copyright (c) 2002-2013 All rights reserved.
 * @create 2012-12-13 上午11:11:02
 **/
public class EncrypDes {
    private static final String key="travelSkyGuiParameter";

    private SecretKeyFactory keyFactory = null;
    // 生成加密密钥
    private DESKeySpec keySpec = null;

    private SecretKey secretKey = null;

    private Cipher cipher = null;

    public EncrypDes() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        //KeySpec组成加密密钥的密钥内容的（透明）规范
        keySpec = new DESKeySpec(key.getBytes());
        keyFactory = SecretKeyFactory.getInstance("DES");
        // key的长度不能够小于8位字节
        secretKey = keyFactory.generateSecret(keySpec);
        cipher = Cipher.getInstance("DES");
    }

    public String Encrytor(String str) throws InvalidKeyException, NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] src = str.getBytes();
        // 加密，结果保存进cipherByte
        byte[] encryByte = cipher.doFinal(src);
        String encryStr = parseByte2HexStr(encryByte);
        return encryStr;
    }

    public String Decryptor(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式
        byte[] encryByte = parseHexStr2Byte(str);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(encryByte));
        /*byte[] decryByte = cipher.doFinal(encryByte);
        return parseByte2HexStr(decryByte);*/
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        EncrypDes des = new EncrypDes();
        EncrypDes des2 = new EncrypDes();
        String msg = "test_1212_我爱你——@#￥%……&";
        String encontent = des.Encrytor(msg);
        String encontent2 = des2.Encrytor(msg);
        String decontent = des.Decryptor(encontent);
        String decontent2 = des2.Decryptor(encontent);
        System.out.println("明文是:" + msg);
        System.out.println("加密后:" + encontent);
        System.out.println("解密后:" +decontent);
        System.out.println("加密后:" + encontent2);
        System.out.println("解密后:" + decontent2);
        System.out.println("is equals:" + encontent.equals(encontent2));
    }
}