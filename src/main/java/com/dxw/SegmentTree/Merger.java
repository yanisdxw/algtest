package com.dxw.SegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
