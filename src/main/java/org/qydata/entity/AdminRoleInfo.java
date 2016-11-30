package org.qydata.entity;

import java.io.Serializable;

/**
 * Created by jonhn on 2016/11/30.
 */
public class AdminRoleInfo implements Serializable {

    private Admin admin;
    private Role role;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AdminRoleInfo{" +
                "admin=" + admin +
                ", role=" + role +
                '}';
    }
}
