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
	 * Create a new complete query from an input string
	 * @param content
	 * 
	 */
	public MyQuery(String content) {
		this.content = content;
		this.isCompleted = true;
	}
	
	/**
	 * Create a new query by copy from another one
	 * @param other
	 */
	public MyQuery(MyQuery other){
		this.content = other.content;
		this.isCompleted = other.isCompleted;
	}

	/**
	 * Default constructor
	 */
	public MyQuery() {
		// TODO Auto-generated constructor stub
		content = "";
	}

	/**
	 * Add some fix prefix and prepare the base of a query
	 */
	public void initial() {
		content = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n "
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n " + "SELECT * WHERE{";
	};

	/**
	 * Set new prefix for query
	 * @param namespace like "ns"
	 * @param path like "http://www.owl-ontologies.com/Ontology1386080076.owl"
	 * 
	 */
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

	/**
	 * Add one more condition for query
	 * @param condition
	 */
	public void addCondition(String condition) {
		content += "\n"+condition;
	}

	
	/**
	 * Buil query
	 * @return a complete query can execute
	 */
	public String buildQuery() {
		this.isCompleted = true;
		return content + "}\n";
	}

	/**
	 * Add filter of query like : order, by,....
	 * @param filter
	 * @return an completed query with filter
	 */
	public String addFilter(String filter) {
		return content + filter;
	}

	/**
	 * get the content of query
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

}
