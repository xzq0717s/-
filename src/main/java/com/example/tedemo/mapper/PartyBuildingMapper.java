package com.example.tedemo.mapper;

import com.example.tedemo.pojo.PartyBuilding;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PartyBuildingMapper {
    @Insert("INSERT INTO party_building_project (project_name, teacher_name, score, evidence_materials, status, create_time, update_time, username) " +
            "VALUES (#{project_name}, #{teacher_name}, #{score}, #{evidence_materials}, #{status}, #{create_time}, #{update_time}, #{username})")
    void addPar(PartyBuilding par);


    @Update("UPDATE party_building_project " +
            "SET project_name = #{project_name}, " +
            "teacher_name = #{teacher_name}, " +
            "score = #{score}, " +
            "evidence_materials = #{evidence_materials}, " +
            "status = #{status}, " +
            "update_time = #{update_time} " +
            "WHERE id = #{id}")
    void PutResFun(PartyBuilding par);
    @Update("update party_building_project set status = #{status} WHERE id = #{id} ")
    void putPopFun(PartyBuilding par);
    @Delete("DELETE FROM party_building_project WHERE id = #{id}")
    void deletepar(Integer id);

    List<PartyBuilding> AdminParlist(String status);

    List<PartyBuilding> Parlist(String username, String status);
}
