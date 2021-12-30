import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxHeap<T> {
    private final List<T> heap;
    private final Comparator<T> comparator;

    public MaxHeap(final T[] array, Comparator<T> comparator) {
        this.comparator = comparator;
        heap = new ArrayList<>();
        Collections.addAll(heap, array);
        buildHeap();
    }

    public MaxHeap(final List<T> list, Comparator<T> comparator) {
        this.comparator = comparator;
        heap = new ArrayList<>(list);
        buildHeap();
    }

    private T getNode(List<T> heap, int index, int rightLim) {
        int lim = Math.min(heap.size(), rightLim);
        if (index >= lim) {
            return null;
        }
        return heap.get(index);
    }

    private void swap(List<T> heap, int i1, int i2) {
        T tmp = heap.get(i1);
        heap.set(i1, heap.get(i2));
        heap.set(i2, tmp);
    }

    private void heapify(List<T> heap, int index, int rightLim) {
        T root = getNode(heap, index, rightLim);
        if (root == null) {
            return;
        }
        T leftChild = getNode(heap, getLeftChildIndex(index), rightLim);
        T rightChild = getNode(heap, getRightChildIndex(index), rightLim);
        int swapIndex = index;
        if (leftChild != null && comparator.compare(root, leftChild) < 0) {
            swapIndex = getLeftChildIndex(index);
        }
        if (leftChild != null && rightChild != null &&
                comparator.compare(root, rightChild) < 0 && comparator.compare(rightChild, leftChild) > 0) {
            swapIndex = getRightChildIndex(index);
        }
        swap(heap, index, swapIndex);
        if (swapIndex == getLeftChildIndex(index)) {
            heapify(heap, getLeftChildIndex(index), rightLim);
        } else if (swapIndex == getRightChildIndex(index)) {
            heapify(heap, getRightChildIndex(index), rightLim);
        }
    }

    private void buildHeap() {
        for (int i = heap.size() / 2; i >= 0 ; i--) {
            heapify(heap, i, heap.size());
        }
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int rootIndex) {
        return (2 * rootIndex) + 1;
    }

    private int getRightChildIndex(int rootIndex) {
        return (2 * rootIndex) + 2;
    }

    private void sortInternal(List<T> heap, int lastIndex) {
        if (lastIndex < 0 || heap.isEmpty()) {
            return;
        }

        swap(heap, 0, lastIndex);
        heapify(heap, 0, lastIndex);
        sortInternal(heap, lastIndex - 1);
    }

    public List<T> sort() {
        List<T> sortedList = new ArrayList<>(heap);
        sortInternal(sortedList, sortedList.size() - 1);
        return sortedList;
    }

    public void insert(T el) {
        heap.add(el);
        int elIndex = heap.size() - 1;
        int parentIndex = getParentIndex(elIndex);
        while (elIndex >= 1 && comparator.compare(heap.get(parentIndex), el) < 0) {
            swap(heap, parentIndex, elIndex);
            elIndex = parentIndex;
            parentIndex = getParentIndex(elIndex);
        }
    }

    public void deleteMaxElement() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }
        swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify(heap, 0, heap.size());
    }

    @Override
    public String toString() {
        // int height = (int) Math.ceil(Math.log(heap.size() + 1) / Math.log(2));
        StringBuilder sb = new StringBuilder();
        int currentLevel = 1;
        for (int i = 0; i < heap.size(); i++) {
            sb.append(heap.get(i));
            sb.append(" ");
            if (i + 2 >= Math.pow(2, currentLevel)) {
                sb.append("\n");
                currentLevel++;
            }
        }
        return sb.toString();
    }

    public List<T> getHeapCopy() {
        return new ArrayList<>(heap);
    }
}
