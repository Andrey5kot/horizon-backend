package com.kot.horizon.user.model;

public enum UserPermission {
	CHARITY_OWNER (UserRole.ROLE_SUB_ADMIN);

	private UserRole userRole;

	UserPermission(UserRole userRole) {
		this.userRole = userRole;
	}

	public UserRole getUserRole() {
		return userRole;
	}
}
