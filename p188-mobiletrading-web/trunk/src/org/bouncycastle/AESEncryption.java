package org.bouncycastle;
/*
 Encrypt and decrypt using the DES private key algorithm
*/

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class AESEncryption {

    private static BufferedBlockCipher cipher;
    private static KeyParameter key;


    private static class AESEncryptionInstance {
        private static final AESEncryption INSTANCE = new AESEncryption();
    }

    public static AESEncryption getInstance(String key){
        setEncryptionParams(key.getBytes());
        return AESEncryptionInstance.INSTANCE;
    }

    private static void setEncryptionParams(byte[] securekey) {
        cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()));
        key = new KeyParameter(securekey);
    }

    public AESEncryption() {}

    private byte[] callCipher(byte[] data)
            throws CryptoException {

        int size = cipher.getOutputSize(data.length);
        byte[] result = new byte[size];
        int olen = cipher.processBytes(data, 0, data.length, result, 0);

        try {
            olen += cipher.doFinal(result, olen);
        } catch (DataLengthException e) {
            e.printStackTrace();
            throw new CryptoException();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new CryptoException();
        } catch (InvalidCipherTextException e) {
            e.printStackTrace();
            throw new CryptoException();
        }

        if (olen < size) {
            byte[] tmp = new byte[olen];
            System.arraycopy(result, 0, tmp, 0, olen);
            result = tmp;
        }
        return result;
    }

    public synchronized byte[] encrypt(byte[] data)
            throws CryptoException {
        if (data == null || data.length == 0) {
            return new byte[0];
        }

        cipher.init(true, key);
        return callCipher(data);
    }

    public byte[] encryptString(String data)
            throws CryptoException {
        if (data == null || data.length() == 0) {
            return new byte[0];
        }

        return encrypt(data.getBytes());
    }

    public synchronized byte[] decrypt(byte[] data)
            throws CryptoException {
        if (data == null || data.length == 0) {
            return new byte[0];
        }

        cipher.init(false, key);
        return callCipher(data);
    }

    public String decryptString(byte[] data)
            throws CryptoException {
        if (data == null || data.length == 0) {
            return "";
        }

        return new String(decrypt(data));
    }
}