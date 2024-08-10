package Classes;

public enum UserRole {
    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN"),
    SUPERADMIN("SUPERADMIN");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String displayRole() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}