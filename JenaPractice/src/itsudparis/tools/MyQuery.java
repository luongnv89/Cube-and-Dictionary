/**
 * 
 */
package itsudparis.tools;

/**
 * @author luongnv89
 * 
 */
public class MyQuery {
	String content;
	boolean isCompleted = false;

	/**
	 * @param content
	 */
	public MyQuery(String content) {
		this.content = content;
		this.isCompleted = true;
	}
	
	public MyQuery(MyQuery other){
		this.content = other.content;
		this.isCompleted = other.isCompleted;
	}

	public MyQuery() {
		// TODO Auto-generated constructor stub
		content = "";
	}

	public void initial() {
		content = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n "
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n " + "SELECT * WHERE{";
	};

	public void setPrefix(String namespace, String path) {
		if (content.equals("")) {
			initial();
		}
		String prefix = "PREFIX " + namespace + ": <" + path + "#>\n";
		if (!content.contains(prefix)) {
			content = prefix + content;
		} else {
			System.out.println(prefix + " already added!");
		}
	}

	public void addCondition(String condition) {
		content += "\n"+condition;
	}

	public String buildQuery() {
		this.isCompleted = true;
		return content + "}\n";
	}

	public String addFilter(String filter) {
		return content + filter;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

}
