package hjg.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiTestInterface extends Remote {
	public String getTest() throws RemoteException;
}
