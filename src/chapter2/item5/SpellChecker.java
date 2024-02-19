package chapter2.item5;

import java.util.List;
import java.util.Objects;

public class SpellChecker {
    /* 정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
    private static final Lexicon dictionary = ...;
    private SpellChecker(){} // 객체 생성 방지
    public static boolean isValid(String word){...}
    public static List<String> suggestions(String typo){...}
    */

    /* 싱글턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
    private final Lexicon dictionary = ...;
    private SpellChecker(...){}
    public static SpellChecker INSTANCE = new SpellChecker(...);

    public boolean isValid(String word){...}
    public List<String> suggestions(String typo){...}
    */

    // 의존 객체 주입은 유연성과 테스트 용이성을 높여준다.
    private final Lexicon dictionary;
    public  SpellChecker(Lexicon dictionary){
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word){...}
    public List<String> suggestions(String typo){...}
}
