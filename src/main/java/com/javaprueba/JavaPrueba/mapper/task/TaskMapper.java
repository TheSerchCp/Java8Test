package com.javaprueba.JavaPrueba.mapper.task;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.javaprueba.JavaPrueba.entity.Task;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("select id,UPPER(name) as name,description,start_date as startDate from task")
    List<Task> selectAll();

    @Insert("insert into task(name,description, start_date) values(#{name},#{description},#{startDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Task task);
}
