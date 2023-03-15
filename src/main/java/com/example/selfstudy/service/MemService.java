package com.example.selfstudy.service;

import com.example.selfstudy.vo.MemVo;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface MemService {

    // 회원 번호 만들기
    String createMemberNumber();

    // 회원가입 유효성 검사
    int saveMemberValidation(MemVo memVo);

    // 회원가입(저장)
    void joinMembership(MemVo memVo);

    // ENCRYPTED_DATA (양방향 암호화 AES-256)
    MemVo encryptionAES(MemVo memVo) throws Exception;

    // DECRYPTED_DATA (양방향 복호화 AES-256)
    MemVo decryptionAES(MemVo memVo) throws Exception;

    // 단방향 암호화 AES-256
    MemVo encryptionSHA(MemVo encryptedData) throws NoSuchAlgorithmException;

    // id, email 중복, 유효성 검사
    Map<String, Object> isContainValidation(MemVo memData);

//    // 중복 memId 확인
//    int idcheck(String memId);
//
//    // 중복 email 확인
//    int emailCheck(String email);

}
