import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {
    @Test
    public void BuildMaxHeap() {
        MaxHeap<Integer> heap = new MaxHeap<>(new Integer[]{38, 28, 19, 28, 14, 0, -5, 12, 11}, Integer::compareTo);
        assertThat(heap.getHeapCopy(), is(List.of(38, 28, 19, 28, 14, 0, -5, 12, 11)));
    }

    @Test
    public void SortMaxHeap() {
        MaxHeap<Integer> heap = new MaxHeap<>(new Integer[]{38, 28, 19, 28, 14, 0, -5, 12, 11}, Integer::compareTo);
        assertThat(heap.sort(), is(List.of(-5, 0, 11, 12, 14, 19, 28, 28, 38)));
    }

    @Test
    public void InsertMaxHeap() {
        MaxHeap<Integer> heap = new MaxHeap<>(new Integer[]{38, 28, 19, 28, 14, 0, -5, 12, 11}, Integer::compareTo);
        heap.insert(20);
        assertThat(heap.getHeapCopy(), is(List.of(38, 28, 19, 28, 20, 0, -5, 12, 11, 14)));
    }

    @Test
    public void DeleteMaxHeap() {
        MaxHeap<Integer> heap = new MaxHeap<>(new Integer[]{38, 28, 19, 28, 14, 0, -5, 12, 11}, Integer::compareTo);
        heap.deleteMaxElement();
        assertThat(heap.getHeapCopy(), is(List.of(28, 28, 19, 12, 14, 0, -5, 11)));
    }
}