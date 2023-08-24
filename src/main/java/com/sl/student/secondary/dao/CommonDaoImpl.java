package com.sl.student.secondary.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.student.primary.model.Datatype;
import com.sl.student.primary.model.KeyValuePair;
import com.sl.student.primary.model.Request;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonDaoImpl implements CommonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String getProcData(Request request) throws JsonProcessingException {

        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(request.procedureName());

        List<KeyValuePair> listKeyValuePairs = request.keyValuePairs();

        for (KeyValuePair keyVal : listKeyValuePairs) {
           // String dataTypeName = keyVal.dataType().wait().toUpperCase();
            Datatype datatype = Datatype.valueOf(keyVal.dataType().toUpperCase());
            storedProcedure.registerStoredProcedureParameter(keyVal.key(), datatype.getClazz(), ParameterMode.IN);
        }

        for (KeyValuePair keyVal : listKeyValuePairs) {
            storedProcedure.setParameter(keyVal.key(), keyVal.value());
        }

        List<Object> objectList = storedProcedure.getResultList();
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(objectList);
    }
}
