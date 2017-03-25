package com.nf11624.wamp.core.message.session.definition;

import com.nf11624.wamp.core.message.MessageDetails;
import com.nf11624.wamp.core.message.session.ClientRoleHolder;

/*
 * Sample structure
 *  "roles": {
             "publisher": {},
             "subscriber": {}
         }
 */
public class HelloMessageDetails implements MessageDetails {

	private ClientRoleHolder roles;

	public ClientRoleHolder getRoles() {
		return roles;
	}

	public void setRoles(ClientRoleHolder roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj instanceof HelloMessageDetails) {
			equal = roles.equals(((HelloMessageDetails) obj).getRoles());
		}
		return equal;
	}

	public Object getDetailObject() {
		return roles;
	}
}
