package project;

public class getParts {
	
	static String makeParts(String first, String[] args, String last) {
		String toReturn = first;
		for(String arg: args) { toReturn += arg; }
		toReturn += last;
		return toReturn;
	}
	
	public static String getHeader() {
		String[] toPass = {""};
		return getHeader(toPass);
	}
	
	public static String getHeader(String[] args) {
		return makeParts("<html><head>", args, "</head>" );
	}
	
	public static String getBody() {
		String[] toPass = {""};
		return getBody(toPass);
	}
	
	public static String getBody(String[] args) {
		return makeParts("<body>", args, "</body>" );
	}
	
	public static String getFooter() {
		String[] toPass = {""};
		return getFooter(toPass);
	}
	
	public static String getFooter(String[] args) {
		return makeParts("<footer>", args, "</footer></html>" );
	}
	
}
