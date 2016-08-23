package ua.nure.soklakov.SummaryTask4.core.user;

/**
 * Roles that can be used.
 * 
 * @author Oleg Soklakov
 *
 */
public enum Role{

	ADMIN, DOCTOR, NURSE;
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Role getRole(User user) {
		int roleId = user.getRoleId();
		return Role.values()[roleId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
	
	

}
