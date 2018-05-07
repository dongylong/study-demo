/**
 * @author dongyl
 * @date 13:45 2/16/18
 * @project study-demo
 */
public class Square {
    long width;

    public Square(long width) {
        this.width = width;
    }

    public static void main(String[] args) {
        Square a,b,c;
        a = new Square(42L);
        b = new Square(42L);
        c =b;
        long s = 42L;
        System.out.println(a.equals(s));
        System.out.println(a==b);
        System.out.println(c==b);
//        System.out.println(a==s);
    }
}
