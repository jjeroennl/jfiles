import java.io.IOException;


public class program {
	public void launch(String folder, String program){

		try {
			Runtime.getRuntime().exec("xdg-open " + folder + "/" + program);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
			
		}
	
	}
}
