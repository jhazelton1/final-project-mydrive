package com.cooksys.mydrive.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    private Folder parent;

    @NotNull
    private String name;

    @NotNull
    private byte[] rawData;

    @NotNull
    private boolean isRoot;

    @NotNull
    private boolean inTrash;

    public File() {
    }

    public File(int id, @NotNull Folder parent, @NotNull String fileName, @NotNull byte[] rawData, @NotNull boolean isTrash) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.rawData = rawData;
        this.inTrash = inTrash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getRawData() {
        return rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }

    public boolean isInTrash() {
        return inTrash;
    }

    public void setInTrash(boolean inTrash) {
        this.inTrash = inTrash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return id == file.id &&
                parent == file.parent &&
                inTrash == file.inTrash &&
                Objects.equals(name, file.name) &&
                Arrays.equals(rawData, file.rawData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, parent, name, inTrash);
        result = 31 * result + Arrays.hashCode(rawData);
        return result;
    }
}
