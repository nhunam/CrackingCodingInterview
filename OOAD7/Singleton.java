/*
 * Singleton Class: this is exactly only one instance of Singleton is created.
 */

package OOAD7;

public class Singleton {
	private static Singleton _instance = null;
	protected Singleton() {
				
	}
	
	public static Singleton getInstance() {
		if (_instance == null) {
			_instance = new Singleton();
		}
		
		return _instance;
	}
}
