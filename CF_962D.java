import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class CF_962D {
    static Heap heap;
    static class Item{
        long value;
        int pos;
        Item(long v, int p){
            value=v;
            pos=p;
        }
        boolean lessThan(Item a){
            if(a.value!=value){
                return value<a.value;
            }
            return pos<a.pos;
        }
    }
    static class Heap{
        Item[] a;
        int heapSize;
        Heap(int n){
            a=new Item[n];
        }
        int parent(int node){
            return (node-1)/2;
        } 
        int leftChild(int node){
            return node*2+1;
        }
        int rightChild(int node){
            return node*2+2;
        }
        void push(Item item){
            a[heapSize]=item;
            int pos=heapSize;
            heapSize++;
            while(pos!=0){
                if(a[pos].lessThan(a[this.parent(pos)])){
                    Item temp=a[pos];
                    a[pos]=a[this.parent(pos)];
                    a[this.parent(pos)]=temp;
                    pos=this.parent(pos);
                }
                else break;
            }
        }
        Item pop(){
            Item ans=a[0];
            a[0]=a[heapSize-1];
            heapSize--;
            int pos=0;
            while(pos*2+1<heapSize){
                int child=this.leftChild(pos);
                if(child+1<heapSize && a[child+1].lessThan(a[child])){
                    child++;
                }
                if(a[child].lessThan(a[pos])){
                    Item temp=a[pos];
                    a[pos]=a[child];
                    a[child]=temp;
                    pos=child;
                }
                else break;
            }
            return ans;
        }
        boolean isEmpty(){
            return heapSize==0;
        }
    }
    public static void main(String[]args){
        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String read;
            read=reader.readLine();
            int n=Integer.parseInt(read);
            long[] a=new long[n];
            boolean[] valid=new boolean[n];
            heap=new Heap(n);
            read=reader.readLine();
            List<String> data=Arrays.asList(read.split(" "));
            for(int i=0;i<n;i++){
                a[i]=Long.parseLong(data.get(i));
                heap.push(new Item(a[i], i));
                valid[i]=true;
            }
            while(true){
                if(heap.isEmpty()) break;
                Item item1=heap.pop();
                if(heap.isEmpty()) break;
                Item item2=heap.pop();

                if(item1.value!=item2.value){
                    heap.push(item2);
                }
                else{
                    heap.push(new Item(2*item2.value, item2.pos));
                    a[item2.pos]=2*item2.value;
                    valid[item1.pos]=false;
                }
            }

            int ans=0;
            for(int i=0;i<n;i++){
                if(valid[i]) ans++;
            }
            System.out.printf("%d\n", ans);
            for(int i=0;i<n;i++){
                if(valid[i]){
                    System.out.printf("%d ", a[i]);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }    
}
