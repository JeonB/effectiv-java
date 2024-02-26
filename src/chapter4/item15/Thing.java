package chapter4.item15;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Thing {
    
    // 클라이언트에서 배열의 내용을 수정할 수 있음
    public static final Thing[] VALUES = {...};
    
    // 위 보안 허점 해결책 1. public을 private으로 만들고 public 불변리스트 추가
    private static final Thing[] PRIVATE_VALUES = {...};
    public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
    
    // 2. 배열을 private으로 만들고 그 복사본을 반환하는 public 메서드를 추가
    private static final Thing[] PRIVATE_VALUES = {...};
    public static final Thing[] values(){
        return PRIVATE_VALUES.clone();
    }

}
