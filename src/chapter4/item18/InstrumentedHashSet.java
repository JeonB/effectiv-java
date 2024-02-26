package chapter4.item18;

import java.util.Collection;
import java.util.HashSet;

/**
 * 
 * 잘못된 예 - 상속을 잘못 사용했다
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    
    // 추가된 원소의 수
    private int addCount = 0;

    public InstrumentedHashSet() {

    }

    public InstrumentedHashSet(int initCap, float loadFacotr) {
        super(initCap, loadFacotr);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}
