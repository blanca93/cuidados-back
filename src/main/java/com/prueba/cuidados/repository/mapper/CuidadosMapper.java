package com.prueba.cuidados.repository.mapper;

import com.prueba.cuidados.repository.entity.CuidadoEntity;
import com.prueba.cuidados.repository.entity.PersonaEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CuidadosMapper {

    @Results(value = {
            @Result(property = "parentCode", column = "parent"),
            @Result(property = "caretakerCode", column = "caretaker"),
            @Result(property = "beginning", column = "beginning"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "description", column = "description")
    })
    @Select("SELECT parent, caretaker, beginning, duration, description FROM cuidados ORDER BY beginning DESC")
    List<CuidadoEntity> getAllCuidados();

    @Insert("INSERT INTO cuidados (parent, caretaker, beginning, duration, description) VALUES (#{parentCode}, #{caretakerCode}, #{beginning}, #{duration}, #{description})")
    void saveCuidado(CuidadoEntity cuidadoToCuidadoEntity);

    @Insert("INSERT INTO parents (parentname) VALUES (#{persona})")
    void savePersona(String persona);

    @Results(value = {
            @Result(property = "code", column = "id"),
            @Result(property = "name", column = "parentname")
    })
    @Select("SELECT id, parentname FROM parents")
    List<PersonaEntity> getAllPersonas();
}
