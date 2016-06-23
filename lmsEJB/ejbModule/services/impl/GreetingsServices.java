package services.impl;

import javax.ejb.Stateless;

import services.interfaces.GreetingsServicesLocal;
import services.interfaces.GreetingsServicesRemote;

/**
 * Session Bean implementation class GreetingsServices
 */
@Stateless
public class GreetingsServices implements GreetingsServicesRemote, GreetingsServicesLocal {

	/**
	 * Default constructor.
	 */
	public GreetingsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayAhla(String name) {
		return "ahla ya :" + name;
	}

}
