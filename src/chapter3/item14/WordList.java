package chapter3.item14;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {
    public static void main(String[] args){
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        
        //String이 Comparable을 구현한 덕분에 명령줄 인수들을 알파벳순으로 출력함
        System.out.println(s);
    }

}
