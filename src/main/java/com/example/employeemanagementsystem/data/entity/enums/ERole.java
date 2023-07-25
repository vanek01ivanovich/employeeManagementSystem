package com.example.employeemanagementsystem.data.entity.enums;

import java.util.Arrays;
import java.util.UUID;

public enum ERole {

    ROLE_ADMIN(UUID.fromString("c34e8eac-2a44-11ee-a929-2c4d543559ae"), "ROLE_ADMIN"),
    ROLE_USER(UUID.fromString("c3529c35-2a44-11ee-a929-2c4d543559ae"), "ROLE_USER");

    private final UUID id;
    private final String name;

    ERole(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getID() {
        return id;
    }

    public static ERole getRoleByName(String name) {
        return Arrays.stream(ERole.values())
                .filter(value -> value.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ERole with value " + name + " is not found"));
    }
}
