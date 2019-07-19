package com.mapper;

import com.entity.Manager;

import java.util.List;

public interface ManagerMapper {
    Manager queryManagerByEntity(Manager manager);
    List<Manager> queryAllManager();
    void addManager(Manager manager);
    void updateManager(Manager manager);
    void deleteManager(Manager manager);
}
