package com.example.selfstudy.service.imp;

import com.example.selfstudy.dao.MemDao;
import com.example.selfstudy.service.MemService;
import com.example.selfstudy.vo.MemVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.regex.Pattern;

import static org.springframework.util.StringUtils.hasText;

@Slf4j
@Service
public class MemImp implements MemService {

    @Autowired
    MemDao memDao;

    /* 회원번호 만들기 */
    @Override
    public String createMemberNumber() {
        String first = "CU"; //회원번호 첫번째
        String today = ""; // 오늘날짜
        String memNo = memDao.findMemNo(); // db에서 가장 최신의 데이터를 memNo에 넣어준다.

        LocalDate now = LocalDate.now(); // 현재 날짜 구하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); // 포맷 정의
        today = now.format(formatter); // ex) 20230303

        if(memNo == null){
            memNo = first + today + "A00001";
        } else if(memNo != null){
            char abc = memNo.charAt(10);
            int num = Integer.parseInt(memNo.substring(11));
            System.out.println("잘린 숫자" + num);

            if(num >= 10000){
                abc = (char) (abc +  1);
                num = 1;
                String numOne = String.format("%05d", num);
                System.out.println("numOne 스트링으로 전환된 =>" + numOne);
                memNo = first + today + abc + numOne;
                System.out.println("알파벳이 증가해버렸지요~ =>" + memNo);
            } else if(num < 10000){
                num = num+1;
                String numPlus = String.format("%05d", num);
                memNo = first + today + abc + numPlus;
                System.out.println("숫자만 증가~ =>" + memNo);
            }
        }

        return memNo;
    }

    /* 유효성 검사 */
    @Override
    public int chkValidation(MemVo memVo) {

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = dateTimeFormat.format(now);

        memVo.setRegDate(nowTime);
        memVo.setUpdateDate(nowTime);

        int result = 0;

        if (memVo == null){
            result = 1;
        } else if(!Pattern.matches("^[가-힣ㄱ-ㅎ]+$", memVo.getMemName())){
            result = 2;
        } else if(!(Pattern.matches("^(?=.*?[0-9])(?=.*?[A-Za-z])(?=.*?[#?!@$ %^&*~-]).{8,20}$", memVo.getMemPassword()))) {
            result = 3;
        } else if(!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$", memVo.getEmail())){
            result = 4;
        } else if(!Pattern.matches("^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", memVo.getPhone())) {
            result = 5;
        }

        return result;
    }

    /* 회원가입(저장) */
    @Override
    public void joinMembership(MemVo memVo) {
        memDao.saveMem(memVo);
    }

    /* ENCRYPTED_DATA (양방향 암호화 AES-256) */
    @Override
    public MemVo encryptionAES(MemVo memVo) throws Exception {

        AesClass ase_256_cbc = new AesClass();

        String name = ase_256_cbc.encrypt(memVo.getMemName());
        String email = ase_256_cbc.encrypt(memVo.getEmail());
        String zipcode = ase_256_cbc.encrypt(memVo.getZipcode());
        String baseAdres = ase_256_cbc.encrypt(memVo.getBaseAdres());
        String detailAdres = ase_256_cbc.encrypt(memVo.getDetailAdres());
        String phone = ase_256_cbc.encrypt(memVo.getPhone());

        memVo.setMemName(name);
        memVo.setEmail(email);
        memVo.setZipcode(zipcode);
        memVo.setBaseAdres(baseAdres);
        memVo.setDetailAdres(detailAdres);
        memVo.setPhone(phone);

       return memVo;
    }

    /* DECRYPTED_DATA (양방향 복호화 AES-256) */
    @Override
    public MemVo decryptionAES(MemVo memVo) throws Exception {

        AesClass ase_256_cbc = new AesClass();

        String name = ase_256_cbc.decrypt(memVo.getMemName());
        String email = ase_256_cbc.decrypt(memVo.getEmail());
        String zipcode = ase_256_cbc.decrypt(memVo.getZipcode());
        String baseAdres = ase_256_cbc.decrypt(memVo.getBaseAdres());
        String detailAdres = ase_256_cbc.decrypt(memVo.getDetailAdres());
        String phone = ase_256_cbc.decrypt(memVo.getPhone());

        memVo.setMemName(name);
        memVo.setEmail(email);
        memVo.setZipcode(zipcode);
        memVo.setBaseAdres(baseAdres);
        memVo.setDetailAdres(detailAdres);
        memVo.setPhone(phone);

        return memVo;
    }

    public static class AesClass{
        //1. 필요한 아이들 선언(시크릿키, iv:직전 암호화된 코드로 xor 계산을 해야하나는데 없는 경우를 위해 생성), 필요한 변수(memVo 데이터)
        private final static String secretKey = "testspringbootsecrekey1234567890"; // 32byte
        private final static String iv = secretKey.substring(0,16); // 16byte

        // 암호화
        public String encrypt(String plainText) throws Exception {

            //2. Cipher 객체 인스턴스화
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

            SecretKeySpec keySpec =  new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));

            //3. Cipher 객체 초기화
            c.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);

            //4. 암호화된 메시지를 포함한 byte 배열을 반환
            byte[] encrpytionByte = c.doFinal(plainText.getBytes("UTF-8"));

            return Base64.getEncoder().encodeToString(encrpytionByte);

        }
        // 복호화
        public String decrypt(String plainText) throws Exception {

            //2. Cipher 객체 인스턴스화
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

            SecretKeySpec keySpec =  new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));

            //3. Cipher 객체 초기화
            c.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);

            //4. 암호화된 메시지를 포함한 byte 배열을 반환
            byte[] decodedBytes = Base64.getDecoder().decode(plainText);
            byte[] decryptionByte = c.doFinal(decodedBytes);

            return new String(decryptionByte, "UTF-8");
        }
    }

    /* 비밀번호 암호화 (단방향 암호화 SHA-256) */
    @Override
    public MemVo encryptionSHA(MemVo encryptedData) throws NoSuchAlgorithmException {
        // 비밀번호 평문
        String raw = encryptedData.getMemPassword();
        String hex = "";

        // "SHA1PRNG"은 알고리즘 이름(16bytes 난수 생성)
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        // SALT 생성
        String salt = new String(Base64.getEncoder().encode(bytes));
        String rawAndSalt = raw+salt;

        System.out.println("raw : "+raw);
        System.out.println("salt : "+salt);

        // update() : 지정된 바이트 데이터를 사용해 다이제스트를 갱신
        // digesst(): 바이트배열로 해쉬를 반환, 패딩 등의 최종 처리를 행해 해시 계산을 완료
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // 평문 암호화
//        md.update(raw.getBytes());
//        hex = String.format("%064x", new BigInteger(1, md.digest()));
//        System.out.println("raw의 해시값 : "+hex);

        // 평문+salt 암호화
        md.update(rawAndSalt.getBytes());
        hex = String.format("%064x", new BigInteger(1, md.digest()));
        System.out.println("raw+salt의 해시값 : "+hex);

        encryptedData.setMemPassword(hex);
        encryptedData.setMemPasswordSalt(salt);


        return encryptedData;

    }


}



