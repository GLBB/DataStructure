package cn.glbb.string;

import org.junit.Before;
import org.junit.Test;

public class MyStringTest {
    MyString myString1;
    MyString myString2;

    @Before
    public void init(){
        myString1 = new MyString("welcome ");
        myString2 = new MyString("to ");
    }

    @Test
    public void test1(){
        MyString concat = myString1.concat(myString2);
        concat.display();
    }

    @Test
    public void test2(){
        MyString concat = myString1.concat(myString2);
        MyString myString = concat.deleteChar(0);
        myString.display();
    }
    // "welcome to "
    @Test
    public void test3(){
        MyString concat = myString1.concat(myString2);
        MyString myString = concat.subString(2, 5);
        myString.display();
    }
}
