package com.example.hackathonfinale.database;

import java.util.List;

public interface IDatabaseHandler {
    public void addEntity(Object object);

    public Object getEntity(int id);

    public List<Object> getAllEntity();

    public int getEntityCount();

    public void updateObject(Object object);

    public void deleteObject(Object object);

    public void deleteAll();
}
