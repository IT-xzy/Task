package utils;


import java.security.MessageDigest;

public class Sha {
    public static String convertByteToHexString(byte[] bytes){
        String  result = "";
        for(int i=0;i<bytes.length;i++){
            int temp = bytes[i] & 0xff;
            String tempHex = Integer.toHexString(temp);
            if(tempHex.length()<2){
                    result +="0"+tempHex;
            }else {
                result += tempHex;
            }
        }
        return result;
    }



    public static String jdksha1(String message){
        try{
            MessageDigest sha1Digest = MessageDigest.getInstance("SHA");
            byte[] sha1Encode = sha1Digest.digest(message.getBytes());
            return convertByteToHexString(sha1Encode);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    public static String jdksha256(String message){
        try{
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
            byte[] sha256Encode = sha256Digest.digest(message.getBytes());
            return convertByteToHexString(sha256Encode);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static String jdksha384(String message){
        try {
            MessageDigest sha384Digest = MessageDigest.getInstance("SHA-384");
            byte[] sha384Encode = sha384Digest.digest(message.getBytes());
            return convertByteToHexString(sha384Encode);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String jdksha512(String message){
        try{
            MessageDigest sha512Digest = MessageDigest.getInstance("SHA-512");
            byte[] sha512Encode = sha512Digest.digest(message.getBytes());
            return convertByteToHexString(sha512Encode);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
