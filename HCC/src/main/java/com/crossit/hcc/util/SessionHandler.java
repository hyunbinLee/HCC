package com.crossit.hcc.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

public class SessionHandler {
	
	private SessionRegistry sessionRegistry;

    public void setSessionRegistry(SessionRegistry sessionRegistry){
    	
    	this.sessionRegistry=sessionRegistry;
    }
    
	public List<SessionInformation> getAllSessions() {

		List<SessionInformation> result = new ArrayList<SessionInformation>();		

		List<Object> principals =  sessionRegistry.getAllPrincipals();		

		for (Object principal : principals) {
			
			result.addAll(sessionRegistry.getAllSessions(principal, false));

		}

		return result;

	}
}
