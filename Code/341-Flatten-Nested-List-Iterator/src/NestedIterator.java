/**
 * Description:
 * Created By xxm
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        LinkedList<Integer> res = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            traverse(nestedInteger, res);
        }
        this.it = res.iterator();
    }

    private void traverse(NestedInteger nestedInteger, LinkedList<Integer> res) {
        if (nestedInteger.isInteger()) {
            res.add(nestedInteger.getInteger());
        }

        for (NestedInteger integer : nestedInteger.getList()) {
            traverse(integer, res);
        }

    }

    @Override
    public Integer next() {
        return this.it.next();
    }

    @Override
    public boolean hasNext() {
        return this.it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */