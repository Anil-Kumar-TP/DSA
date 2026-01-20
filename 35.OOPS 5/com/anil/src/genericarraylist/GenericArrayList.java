package com.anil.src.genericarraylist;

import java.util.Arrays;

public class GenericArrayList<T> {

    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public GenericArrayList(){
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T t){
        if (isFull()){
            resize();
        }
        data[size++] = t;
    }

    public T remove(){
        T removedItem = (T) data[--size];
        return removedItem;
    }

    public T get(int index){
        return (T) data[index];
    }

    private int size(){
        return size;
    }

    public void set(int index,T value){
        data[index] = value;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        return "GenericArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
