import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class CF_1111C{
    public static long calculateF(long[] C, long i, long j, int A, int B){
        int l=upperBound(C, i);
        int r=lowerBound(C, j);
        // System.out.println("i "+i+" j= "+j+" l="+l+" r="+r);
        if(l==-1 || r==-1 || r<l){
            // System.out.println("i="+i+" j="+j+" ans: "+A);
            return (long)A;
        }
        else {
            long ans1=(long)B*(long)(r-l+1)*(j-i+1);
            long m=(i+j)/2;
            long ans2=(long) 1e15;
            if(i<j) ans2=calculateF(C, i, m, A, B)+calculateF(C, m+1, j, A, B);
            // System.out.println(" i="+i+" j="+j+" ans: "+Math.min(ans1, ans2));
            return Math.min(ans1, ans2);
        }
    }
    public static int upperBound(long[] C, long x){
        int l=0;
        int r=C.length-1;
        int ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(C[m]>=x){
                ans=m;
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return ans;
    }
    public static int lowerBound(long[]C, long x){
        int l=0;
        int r=C.length-1;
        int ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(C[m]>x){
                r=m-1;
            }
            else{
                ans=m;
                l=m+1;
            }
        }
        return ans;
    }
    public static void main(String[]args){
        int n, k, A, B;
        
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try{
            String line =reader.readLine();
            List<String>tmp=Arrays.asList(line.split(" "));
            n=Integer.parseInt(tmp.get(0));
            k=Integer.parseInt(tmp.get(1));
            A=Integer.parseInt(tmp.get(2));
            B=Integer.parseInt(tmp.get(3));
            line=reader.readLine();
            long[] C=new long[k];
            tmp=Arrays.asList(line.split(" "));
            for(int i=0;i<k;i++){
                C[i]=Long.parseLong(tmp.get(i));
            }
            Arrays.sort(C);
            // System.out.printf("Modified arr[] : %s\n",Arrays.toString(C));
            long ans=calculateF(C, 1, (long)Math.pow(2, n), A, B);
            System.out.println(ans);
        }   
        catch(Exception e){
            e.printStackTrace();
        }
    }
}