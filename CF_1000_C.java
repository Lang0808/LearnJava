import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class CF_1000_C {
    public static int findIndex(List<Long> a, long x){
        int l=0;
        int r=a.size()-1;
        while(l<=r){
            int m=(l+r)/2;
            if(a.get(m)>x){
                r=m-1;
            }
            else if(a.get(m)<x){
                l=m+1;
            }
            else return m;
        }
        return -1;
    }
    public static void main(String[] args){
        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String read=reader.readLine();
            int n=Integer.parseInt(read);
            long[][] b=new long[n][2];
            TreeSet<Long> ts=new TreeSet<>();
            for(int i=0;i<n;i++){
                read=reader.readLine();
                List<String> data=Arrays.asList(read.split(" "));
                long x=Long.parseLong(data.get(0));
                long y=Long.parseLong(data.get(1));
                b[i][0]=x;
                b[i][1]=y+1;
                ts.add(x);
                ts.add(y+1);
            }
            List<Long>a=new ArrayList<>(ts);
            int[] c=new int[a.size()];
            for(int i=0;i<n;i++){
                int id=findIndex(a, b[i][0]);
                c[id]++;
                id=findIndex(a, b[i][1]);
                c[id]--;
            }
            for(int i=1;i<c.length;i++){
                c[i]=c[i-1]+c[i];
            }
            long[] cnt=new long[n+1];
            for(int i=0;i<c.length-1;i++){
                cnt[c[i]]+=(a.get(i+1)-a.get(i));
            }
            for(int i=1;i<cnt.length;i++){
                System.out.printf("%d ", cnt[i]);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
}
