package com.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class utils {
    public SqlSessionFactory getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";

        InputStream in = Resources.getResourceAsStream(resource);

        SqlSessionFactory factory  = new SqlSessionFactoryBuilder().build(in);
        System.out.println("successful session factory");
        return factory;
    }

    public String List2Json(List list) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }

    public String getID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
