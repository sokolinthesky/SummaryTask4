package ua.nure.soklakov.SummaryTask4.core.user;

/**
 * User role type.
 * 
 * @author Oleg Soklakov
 *
 */
public enum Role {

	ADMIN, DOCTOR, NURSE;
	
	public static Role getRole(User user) {
		int roleId = user.getRoleId();
		return Role.values()[roleId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
	
	

}
