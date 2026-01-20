package com.anil.src.customarraylist;

import java.util.Arrays;

public class CustomArrayList {


    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;//also working as index value.

    public CustomArrayList(){
        data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if (isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {

        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public int remove(){
        int removedItem = data[--size];
        return removedItem;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index,int value){
        data[index] = value;
    }

    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
