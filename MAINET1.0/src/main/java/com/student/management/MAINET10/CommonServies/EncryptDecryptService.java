package com.student.management.MAINET10.CommonServies;

public interface EncryptDecryptService {

    public void encryptPassword(String userId, String password);

    public void decryptPassword(String userId, String password);
}
