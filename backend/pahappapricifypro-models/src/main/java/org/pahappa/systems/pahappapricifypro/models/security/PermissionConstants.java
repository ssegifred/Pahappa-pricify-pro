package org.pahappa.systems.pahappapricifypro.models.security;

public final class PermissionConstants {
    private PermissionConstants() {
    }

    @SystemPermission(name = "Api user", description = "Has role for api users")
    public static final String PERM_API_USER = "Api User";

}
