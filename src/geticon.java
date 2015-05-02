
public class geticon {
	String grab(String url){
		if(url.contains(".") == false){
			//folder;
			return "/usr/share/icons/gnome/48x48/apps/file-manager.png";
		}
		else if(url.contains(".png")){
			return "/usr/share/icons/gnome/48x48/mimetypes/image.png";
		}
		else if(url.contains(".jpg")){
			return "/usr/share/icons/gnome/48x48/mimetypes/image.png";
		}
		else{
			return "/usr/share/icons/gnome/48x48/mimetypes/image.png";
		}
	}
}
