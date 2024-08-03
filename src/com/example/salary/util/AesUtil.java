package com.example.salary.util;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.alibaba.excel.util.StringUtils;

import java.security.Security;

public class AesUtil {


    public final static String key = "5434d09c46abbf72cea979d95c29e0d5";
    public final static byte[] key_arr = HexUtil.decodeHex(key.toCharArray());

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    private AesUtil() {

    }

    /**
     * 加密
     */
    public static String encrypt(String input) {
        if (StringUtils.isEmpty(input)) {
            return input;
        }
        return SecureUtil.aes(key_arr).encryptHex(input.getBytes());
    }

    /**
     * 解密
     */
    public static String decrypt(String input) {
        if (StringUtils.isEmpty(input)) {
            return input;
        }
        return SecureUtil.aes(key_arr).decryptStr(input);

    }

    public static void main(String[] args) {

        // 指定AES密钥长度，例如256位
        int keyLength = 128;

        // 生成AES密钥
        byte[] bbb = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue(), keyLength).getEncoded();
        // 将密钥转换为16进制字符串
        String hexKey = HexUtil.encodeHexStr(bbb);
        // 打印16进制密钥
        System.out.println("16进制表示的AES密钥: " + hexKey);
        String a = SecureUtil.aes(key_arr).encryptHex("ABSSS".getBytes());
        System.out.println(a);
        String b = SecureUtil.aes(key_arr).decryptStr(a);
        System.out.println(b);
    }

}
