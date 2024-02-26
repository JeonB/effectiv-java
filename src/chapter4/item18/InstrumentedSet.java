package chapter4.item18;

import java.util.Collection;
import java.util.Set;

/**
 * 상속 대신 컴포지션을 사용했다
 * @param <E>
 */
public class InstrumentedSet<E> extends FowardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
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

    public int getAddCount() {
        return addCount;
    }
}
