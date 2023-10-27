package team.marco.vouchermanagementsystem.model;

import static java.text.MessageFormat.format;

import java.util.UUID;

public class BlacklistUser {
    private final UUID id;
    private final String name;

    public BlacklistUser(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getInfo() {
        return format("id: {0}, 고객명: {1} ", id, name);
    }
}