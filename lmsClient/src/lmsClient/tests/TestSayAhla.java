package lmsClient.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.GreetingsServicesRemote;

public class TestSayAhla {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		GreetingsServicesRemote greetingsServicesRemote = (GreetingsServicesRemote) context
				.lookup("/lms/lmsEJB/GreetingsServices!services.interfaces.GreetingsServicesRemote");
		
		System.out.println(greetingsServicesRemote.sayAhla("wafa"));

	}
}
