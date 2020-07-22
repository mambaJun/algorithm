package com.jun.算法笔记._2._4;

/**
 * @author: Jun
 * @date: 2020/7/17 15:05
 */
public interface MaxPQ<Key> extends Comparable<Key> {

//    public MaxPQ() ;
//
//    public MaxPQ(int max) ;
//
//    public MaxPQ(int[] a) ;

    public void insert(Key v);

    public Key max();

    public void delMax();

    boolean isEmpty();

    int size();
}
