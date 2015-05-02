import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class getList {
	ArrayList<String> get(String url){
		ArrayList<String> list = new ArrayList<String>(); 
		String s;
		
		
        Process p;
        try {
            p = Runtime.getRuntime().exec("ls " + url );
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null){

            	if(s != "null"){
            		
            			list.add(s);
            			
            	}
            	else{
    
            		
            	}
         
            p.waitFor();
            //System.out.println(s);
            }
        } catch (Exception e1){
        	System.out.println("FOUT!");
        }
		return list;
	}
}
