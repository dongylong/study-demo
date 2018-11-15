package com.datastructuress.alg;

/**
 * @author dongyl
 * @date 16:58 12/21/17
 * @project encourage-svr
 */
public class Alg {
    public void bigNumberAlg() {
        long fNum = 123456789;
        long fNumLen = String.valueOf(fNum).length();
        long sNum = 123456789;
        long sNumLen = String.valueOf(sNum).length();
        calculate(fNum, fNumLen, sNum, sNumLen);
    }

    private long calculate(long fNum, long fNumLen, long sNum, long sNumLen) {
        //XY=AC10n+[(A-B)(D-C)+AC+BD]10n/2+BD
        //XY=A*C*Math.pow(10,n)+[(A-B)(D-C)+A*C+B*D]*Math.pow(10,n)/2+B*D
        long sum = 0;
        if (fNumLen == 0 || sNumLen == 0) {
            return 0;
        } else if (fNumLen == 1 && sNumLen == 1) {
            return fNum * sNum;
        }
//        else if (fNumLen == 1 || sNumLen == 1) {
//
//        }
        long fNumH = (long) (fNum % Math.pow(10, fNumLen / 2));
        long fNumHLen = String.valueOf(fNumH).length();
        long fNumL = (long) (fNum / Math.pow(10, fNumLen / 2));
        long fNumLLen = String.valueOf(fNumL).length();
        long sNumH = (long) (sNum % Math.pow(10, sNumLen / 2));
        long sNumHLen = String.valueOf(sNumH).length();
        long sNumL = (long) (sNum / Math.pow(10, sNumLen / 2));
        long sNumLLen = String.valueOf(sNumL).length();
        print(fNumH, fNumL, sNumH, sNumL);
        long fNumAsNumA = calculate(fNumH, fNumHLen, sNumH, sNumHLen);
        long fNumBsNumB = calculate(fNumL, fNumLLen, sNumL, sNumLLen);
//        sum =
        return sum;

    }

    private void print(long fNumH, long fNumL, long sNumH, long sNumL) {
        System.out.println("fNumH : " + fNumH + ", fNumL :" + fNumL);
//        System.out.println("fNumHLen : " + fNumHLen + ", fNumLLen :" + fNumLLen);
        System.out.println("sNumH : " + sNumH + ", sNumL :" + sNumL);
//        System.out.println("sNumHLen : " + sNumHLen + ", sNumLLen :" + sNumLLen);
    }

    public void bigNumber() {
        long a = 123456789;
        long b = 123456789;
        System.out.println("a*b :" + a * b);
        //15241578750190521
    }
}
