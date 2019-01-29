package com.componentwise.eval;

import java.io.Serializable;

/**
 * 
 * @author Jorvon Carter
 *
 * Instances of the UserKey class must be placed into the session of a servlet 
 * and used as a key for a Hashtable of other objects. For that purpose,
 * The hashCode() and equals() methods have been overridden and modified. 
 */
public class UserKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String userid;

	public UserKey(String name, String userid) {
		this.name = name;
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public String getUserID() {
		return userid;
	}

	/**
	 * @return a unique hashcode for a UserKey instance
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	/**
	 * @param obj is, in this case, the UserKey object
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserKey other = (UserKey) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
}

