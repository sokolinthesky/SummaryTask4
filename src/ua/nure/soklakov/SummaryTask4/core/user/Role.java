package ua.nure.soklakov.SummaryTask4.core.user;

/**
 * User role type.
 * 
 * @author Oleg Soklakov
 *
 */
public enum Role{

	ADMIN, DOCTOR, NURSE;
	
	private int id;
	
	public int getId() {
		/*Role[] roles = Role.values();
		for(int i = 0; i < roles.length; i++) {
			if (roles[i].equals(role)) {
				this.id = i;
				break;
			}
		}*/
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
