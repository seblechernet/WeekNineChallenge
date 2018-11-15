package com.seb.weekninechallenge.Model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;

    @Column(unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<AppUser> users;

    public Role(){
        users=new ArrayList<>();
    }

    public Role(String role){
        this.role=role;
        users=new ArrayList<>();
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }
}
