package services.interfaces;

import javax.ejb.Remote;

@Remote
public interface GreetingsServicesRemote {
	String sayAhla(String name);
}
