import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_11B {
    public static void main(String[]args){
        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String read;
            read=reader.readLine();
            int x=Integer.parseInt(read);
            if(x<0) x=-x;
            int i=0;
            int sum=0;
            while(true){
                sum=sum+i;
                if(sum>=x && (sum-x)%2==0){
                    break;
                }
                i++;
            }
            System.out.println(i);
        }
        catch(Exception e){

        }
        
    }    
}
