package cn.glbb.string;

import java.util.Arrays;

public class MyString {
    protected char[] chars;

    public MyString (String str){
        chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
    }

    private MyString() {
    }

    public MyString concat(MyString str) {
        if (chars==null || str.chars==null){
            throw new RuntimeException("chars is null");
        }
        MyString myString = new MyString();
        int total = chars.length + str.chars.length;
        myString.chars = new char[total];

        for (int i=0; i<chars.length; i++) {
            myString.chars[i] = chars[i];
        }
        for (int i=chars.length; i<total; i++) {
            myString.chars[i] = str.chars[i-chars.length];
        }

        return myString;
    }

    /**
     * @param index 索引
     * @return
     */
    public MyString deleteChar(int index){
        if (chars == null) {
            throw new RuntimeException("chats is null");
        }
        if (index >= chars.length) {
            throw new RuntimeException("index out bound");
        }
        MyString myString = new MyString();
        myString.chars = new char[chars.length - 1];
        for (int i=0; i<myString.chars.length; i++) {
            if (i < index) {
                myString.chars[i] = chars[i];
            }else {
                myString.chars[i] = chars[i+1];
            }
        }
        return myString;
    }

    /**
     *
     * @param start 开始索引
     * @param end 结束索引
     * @return
     */
    public MyString subString(int start, int end){
        int length = end - start + 1;
        MyString myString = new MyString();
        myString.chars = new char[length];
        for (int i = start; i <= end; i++) {
            myString.chars[i-start] = chars[i];
        }
        return myString;
    }

    public void display() {
        for (int i=0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
