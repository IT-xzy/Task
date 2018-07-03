package launch;


import org.apache.tuscany.sca.host.embedded.SCADomain;

public class Launch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting...");
		SCADomain scaDomain = SCADomain.newInstance("store.composite");
		System.out.println("store,composite ready for big business !!!");
		System.in.read();
		System.out.println("Stopping");
		scaDomain.close();
		System.out.println();
	}

}
