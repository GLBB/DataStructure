package cn.glbb.hash;

import org.junit.Test;

import java.util.HashMap;

public class HashTest {
    @Test
    public void test1(){
        Integer i = new Integer(5);
        System.out.println(i.hashCode());
        Integer j = 5;
        System.out.println(j.hashCode());

        Byte a = -1;
        System.out.println("max value : "+Byte.MAX_VALUE+" min value :"+Byte.MIN_VALUE);
        System.out.println(a);
        System.out.println(Byte.BYTES);
        System.out.println(a.toString());

        int b = -1;
        b = b>>2;
        System.out.println(b);
    }

    int supplementalHash(int h){
        h ^= (h>>>20)^(h>>>12);

        int z = h ^ (h>>>7) ^ (h>>>4);
        return z;
    }

    @Test
    public void test2(){
        String s = "glbb";
        int hashCode = s.hashCode();

    }
}
