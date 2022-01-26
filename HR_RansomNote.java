import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HR_RansomNote{
    public static void main(String[] args){
        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String read=reader.readLine();
            List<String> data=Arrays.asList(read.split(" "));
            int m=Integer.parseInt(data.get(0));
            int n=Integer.parseInt(data.get(1));
            read=reader.readLine();
            Map<String, Integer> hs=new HashMap<>();
            data=Arrays.asList(read.split(" "));
            for(int i=0;i<m;i++){
                if(hs.containsKey(data.get(i))){
                    hs.put(data.get(i), hs.get(data.get(i))+1);
                }
                else{
                    hs.put(data.get(i), 1);
                }
            }
            read=reader.readLine();
            data=Arrays.asList(read.split(" "));
            boolean ans=true;
            for(int i=0;i<n;i++){
                if(!hs.containsKey(data.get(i))){
                    ans=false;
                    break;
                }
                else{
                    int temp=hs.get(data.get(i));
                    hs.put(data.get(i), temp-1);
                    if(temp==1){
                        hs.remove(data.get(i));
                    }
                }
            }
            if(ans){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}