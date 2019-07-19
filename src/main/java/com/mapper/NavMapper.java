package com.mapper;

import com.entity.Nav;

import java.util.List;

public interface NavMapper {
    List<Nav> queryAllNav();
    void addNav(Nav nav);
    void updateNav(Nav nav);
    void deleteNav(Nav nav);

}
