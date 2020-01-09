package org.deloitte.telecom.dto;

import org.deloitte.telecom.entities.MobileUser;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class
SessionData {

    private MobileUser user;

    public void setUser(MobileUser user){
        this.user=user;
    }

    public MobileUser getUser(){
        return user;
    }

    private MobileUser balance;

	public MobileUser getBalance() {
		return balance;
	}

	public void setBalance(MobileUser balance) {
		this.balance = balance;
	}
}
