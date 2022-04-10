import ilog.concert.*;
import ilog.cplex.*;
import ilog.cplex.IloCplex.Param.Simplex;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 
	public static void model1() {
		int n=18;
		int p[]= {2,16,9,8,10,6,2,2,9,5,3,2,1,7,4,3,9,1};
		int z=0;
		
		  try {
	        	// define new model
	        	IloCplex cplex = new IloCplex();
	        	// variables
	        	IloNumVar[] t = new IloNumVar[n];
	        
	        	// expressions
	        	
	        	IloLinearNumExpr objective = cplex.linearNumExpr();
	        	for (int i=0; i<n; i++) {
	        			objective.addTerm(t[n], n);
	        		
	        	}
	        	// define objective
	        	cplex.addMinimize(objective);
	        	// constraints1
	        	for (int i=0; i<n; i++) {
	        	 	for (int j=0; j<n; j++) {
	        	 	 
		        	cplex.addLe(t[i]+p[i], t[j]);
		        	
		        	}
	        		
	        	}
	        	// constraints2
	        	for (int i=0; i<n; i++) {
	        		cplex.addLe(z, t[i]);
	        	}
	        	
				cplex.setParam(IloCplex.Param.Simplex.Display, 0);
	        	
	        	// solve model
	        	if (cplex.solve()) {
	        		System.out.println("obj = "+cplex.getObjValue());
	        	}
	        	else {
	        		System.out.println("problem not solved");
	        	}
	        	
	        	cplex.end();
	        }
	        catch (IloException exc) {
	        	exc.printStackTrace();
	        }
		}

	
	
}
