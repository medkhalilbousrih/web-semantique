package esprit.microservice;

import org.apache.jena.rdf.model.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
	
	Model model = JenaEngine.readModel("data/Ferme-pr.owl");


	@GetMapping("/employee")
	@CrossOrigin(origins = "http://localhost:3000")
	public String afficherEmp() {
		String NS = "";
		// lire le model a partir d'une ontologie
		if (model != null) {
			// lire le Namespace de l�ontologie
			NS = model.getNsPrefixURI("");

			// apply our rules on the owlInferencedModel
			Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");

			// query on the model after inference
			String res =  JenaEngine.executeQueryFile(inferedModel, "data/employee_query.txt");
			System.out.println(res);
			return res;
			

		} else {
			return ("Error when reading model from ontology");
		}
	}
	
	@GetMapping("/animaux")
	@CrossOrigin(origins = "http://localhost:3000")
	public String afficherAnim() {
		String NS = "";
		// lire le model a partir d'une ontologie
		if (model != null) {
			// lire le Namespace de l�ontologie
			NS = model.getNsPrefixURI("");

			// apply our rules on the owlInferencedModel
			Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");

			// query on the model after inference
			String res =  JenaEngine.executeQueryFile(inferedModel, "data/query_animaux.txt");
			System.out.println(res);
			return res;
			

		} else {
			return ("Error when reading model from ontology");
		}
	}
	
	@GetMapping("/produits")
	@CrossOrigin(origins = "http://localhost:3000")
	public String afficherProd() {
		String NS = "";
		// lire le model a partir d'une ontologie
		if (model != null) {
			// lire le Namespace de l�ontologie
			NS = model.getNsPrefixURI("");

			// apply our rules on the owlInferencedModel
			Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");

			// query on the model after inference
			String res =  JenaEngine.executeQueryFile(inferedModel, "data/query_produits.txt");
			System.out.println(res);
			return res;
			

		} else {
			return ("Error when reading model from ontology");
		}
	}

}
