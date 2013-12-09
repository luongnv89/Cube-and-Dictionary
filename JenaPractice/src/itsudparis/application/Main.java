/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package itsudparis.application;

import java.beans.FeatureDescriptor;
import java.util.Scanner;

import com.hp.hpl.jena.rdf.model.Model;

import itsudparis.tools.JenaEngine;
import itsudparis.tools.MyQuery;

/**
 * @author DO.ITSUDPARIS
 */
public class Main {

	public static final String modelPath = "data/Family.owl";
	public static final String owlInferencedModelPath = "data/owlrules.txt";
	private static final String inferenceModelPath = "data/rules.txt";
	private static final String queryPath = "data/query.txt";
	static Model owlInferencedModel;
	static Model inferedModel;
	static Model model;
	static String NS = "";

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		// lire le model a partir d'une ontologie
		model = JenaEngine.readModel(modelPath);
		if (model != null) {
			// lire le Namespace de l’ontologie
			NS = model.getNsPrefixURI("");
			// modifier le model
			// stuff();
			applyRules();
			// executeQuery(queryPath);
			myOntology();

		} else {
			System.out.println("Error when reading model from ontology");
		}
	}

	private static void myOntology() {
		boolean stop = false;
		while (!stop) {
			String name = askName();
			if (name.equals("X")) {
				System.out.println("Goobye...");
				stop = true;
			} else {
				System.out.println("Welcome " + name);
				// System.out.println(JenaEngine.executeQueryFile(inferedModel,
				// queryPath));
				MyQuery myquery = new MyQuery();
				myquery.setPrefix("ns", "http://www.owl-ontologies.com/Ontology1386080076.owl");
				// Add condition to build query here
				// myquery.addCondition("?per ns:name ?name. ");
				myquery.addCondition("?per ns:name \"" + name + "\".");

				/**
				 * - Ask for the name of a person - Display all the parents,
				 * brothers or sisters if exist.
				 * */
				System.out.println("General information\n");
				MyQuery query_ab = new MyQuery(myquery);
				query_ab.addCondition("{?per ns:age ?age. }");
				query_ab.addCondition("UNION{?parent ns:isParentOf ?per.}");
				query_ab.addCondition("UNION{?brother ns:isBrotherOf ?per.}");
				query_ab.addCondition("UNION{?sister ns:isSisterOf ?per.}");
				System.out.println(JenaEngine.executeQuery(inferedModel, query_ab.buildQuery()));

				MyQuery select_spouse = new MyQuery();
				select_spouse.setPrefix("ns", "http://www.owl-ontologies.com/Ontology1386080076.owl");
				select_spouse.addCondition("?per ns:isMarriedWith ?spouse.");
				String listSpouse = JenaEngine.executeQuery(inferedModel, select_spouse.buildQuery());
				/**
				 * -If this person is married, show the name and the age of
				 * his/her spouse
				 * */
				if (listSpouse.contains(name)) {
					System.out.println(name + ": is married with: \n");
					MyQuery query_spouse = new MyQuery(myquery);
					query_spouse.addCondition("?spouse ns:isMarriedWith ?per. " + "?spouse ns:name ?spouseName."
							+ "?spouse ns:age ?spouseAge.");
					System.out.println(JenaEngine.executeQuery(inferedModel, query_spouse.buildQuery()));
				}
				/**
				 * -If this person is not married, select all the persons where:
				 * -The sex is different 
				 * -The age is close (+ or - 5 years) 
				 * -And is also not married
				 * */
				else {
					System.out.println(name + ": is not married\n");
					// Get list male
					MyQuery select_male = new MyQuery();
					select_male.setPrefix("ns", "http://www.owl-ontologies.com/Ontology1386080076.owl");
					select_male.addCondition("?per rdf:type ns:Male.");
					String listMale = JenaEngine.executeQuery(inferedModel, select_male.buildQuery());

					// Get list female
					MyQuery select_female = new MyQuery();
					select_female.setPrefix("ns", "http://www.owl-ontologies.com/Ontology1386080076.owl");
					select_female.addCondition("?per rdf:type ns:Female.");
					String listFemale = JenaEngine.executeQuery(inferedModel, select_female.buildQuery());
					System.out.println("The sex is different: \n");
					if (listMale.contains(name)) {
						System.out.println(name + ": male\n");
						System.out.println(listFemale);
					}
					else{
						System.out.println(name + ": female\n");
						System.out.println(listMale);
					}
				}
			}
		}

	}

	private static String askName() {
		Scanner in = new Scanner(System.in);
		System.out.println("Give a nam (Or input \"X\" to exit): ");
		String name = in.nextLine();
		return name;
	}

	private static void stuff() {
		// Ajouter une nouvelle femme dans le modele: Nora, 50, estFilleDe
		// Peter
		JenaEngine.createInstanceOfClass(model, NS, "Female", "Nora");
		JenaEngine.updateValueOfDataTypeProperty(model, NS, "Nora", "age", 50);
		JenaEngine.updateValueOfObjectProperty(model, NS, "Nora", "isDaughterOf", "Peter");

		// Ajouter un nouvel homme dans le modele: Rob, 51, seMarierAvec
		// Nora
		JenaEngine.createInstanceOfClass(model, NS, "Male", "Rob");
		JenaEngine.updateValueOfDataTypeProperty(model, NS, "Rob", "age", 51);
		JenaEngine.updateValueOfDataTypeProperty(model, NS, "Rob", "name", "Rob Yeung");
		JenaEngine.updateValueOfObjectProperty(model, NS, "Rob", "isMariedWith", "Nora");

	}

	private static void applyRules() {
		// apply owl rules on the model
		owlInferencedModel = JenaEngine.readInferencedModelFromRuleFile(model, owlInferencedModelPath);
		// apply our rules on the owlInferencedModel
		inferedModel = JenaEngine.readInferencedModelFromRuleFile(owlInferencedModel, inferenceModelPath);

	}

	private static void executeQuery(String querypath2) {
		// query on the model after inference
		System.out.println(JenaEngine.executeQueryFile(inferedModel, queryPath));

	}
}
