package com.example.demo;

import com.example.demo.vo.SVNItem;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ObjectTest {
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    private String getSHA256(String str) {
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodestr;
    }


    @Test
    public void qDes(){
        try {
            KeyGenerator des = KeyGenerator.getInstance("DES");
            des.init(56);
            SecretKey secretKey = des.generateKey();
            byte[] bs = secretKey.getEncoded();

            DESKeySpec desKeySpec = new DESKeySpec(bs);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");


        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void g2son(){
        SVNItem svnItem =new SVNItem(1,"zxs","gyx","2q3","sa","as");
        System.out.println(getSHA256(svnItem.getFilePath()));
        System.out.println(getSHA256(svnItem.getPassword()));


        System.out.println(new Gson().toJson(svnItem));
        String osname = System.getProperty("os.name").toLowerCase();
        if(osname.indexOf("win")!=-1){
            System.out.println(osname);
            System.out.println("test.bat");
        }else{
            System.out.println("test.sh");
        }
    }
}
