import java.util.Arrays;

public class BinaryHeap {
    protected int[] a;
    protected int size;

    public BinaryHeap(){
        a = new int[10];
        size = 0;


    }

    private int parent(int pos){
        return (pos/2);
    }

    private void swap(int pos1,int pos2){
        int temp;
        temp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = temp;
    }

    protected int[] resize() {
        return Arrays.copyOf(a, a.length * 2);
    }

    public void add(int elem){

        if (size >= a.length - 1) {
            a = this.resize();
        }




        a[size++] = elem;
        int i = 1;
        int temp = a[i];
        while(i>0 && temp > a[parent(i)]){
            a[i] = a[parent(i)];
            i = parent(i);
        }
        a[i] = temp;

    }



    public void siftdown(int pos){


        int child = 2 * pos + 1;
        //Base case
        if(child>=size)
            return;
        if(child +1 < size && a[child]<a[child+1])
            ++child;
        if(a[pos]<a[child]){
            swap(pos,child);
            siftdown(child);
        }
    }


    public int remove(){

        int result = a[0];
        swap(1,size);
        size--;
        if(size != 0)
            siftdown(1);



        return result;
    }




}
