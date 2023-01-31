package org.pdl.pojo;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Team {
    private int id;
    private User[] users;
    private String name;

    private Map<Integer,Organization> orgMap;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", users=" + Arrays.toString(users) +
                ", name='" + name + '\'' +
                ", orgMap=" + orgMap +
                '}';
    }

    public Map<Integer, Organization> getOrgMap() {
        return orgMap;
    }

    public Team setOrgMap(Map<Integer, Organization> orgMap) {
        this.orgMap = orgMap;
        return this;
    }

    public int getId() {
        return id;
    }

    public Team setId(int id) {
        this.id = id;
        return this;
    }

    public User[] getUsers() {
        return users;
    }

    public Team setUsers(User[] users) {
        this.users = users;
        return this;
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }
}
