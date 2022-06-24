package encapsulation;

public class Contac600 {
	private SnivelCapsule sni;
	private SneezeCapsule snz;
	private SnffleCapsule snf;
	
	public Contac600() {
		sni = new SnivelCapsule();
		snz = new SneezeCapsule();
		snf = new SnffleCapsule();
	}
	
	public void take() {
		sni.take();
		snz.take();
		snf.take();
		
	}

}
