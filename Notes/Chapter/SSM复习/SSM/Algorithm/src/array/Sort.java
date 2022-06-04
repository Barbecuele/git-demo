package array;

import java.util.Arrays;

public class Sort {

    int[] arr;
    int size;

    public Sort(int capacity){
        arr = new int[capacity];
        size=0;
    }

    public Sort(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return arr.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(int element){
        add(size,element);
    }

    public int getValue(int index){
        if (index<0 || index>size){
            throw new IllegalArgumentException("Get failed, Index is illegal");
        }
        return arr[index];
    }



    public void add(int index,int element){

        if (size==arr.length){
            throw new ArrayIndexOutOfBoundsException("数组满了");
        }

        if(index < 0 || index >arr.length){
            throw new ArrayIndexOutOfBoundsException("数字不符合规范");
        }

        for (int i = size-1; i>=index; i--) {
            arr[i+1]=arr[i];
        }
        arr[index]=element;
        size++;
    }

    public void delete(int index){

        if(size < 0 || size >arr.length){
            throw new ArrayIndexOutOfBoundsException("数字不符合规范");
        }

        for (int i = index; i<size; i++) {
            arr[i]=arr[i+1];
        }
        size--;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "arr=" + Arrays.toString(arr) +
                '}' + "\n" + this.getSize();
    }
}
