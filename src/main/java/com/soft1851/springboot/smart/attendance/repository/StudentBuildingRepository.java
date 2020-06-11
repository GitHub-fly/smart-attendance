package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.StudentBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZENG
 */
public interface StudentBuildingRepository extends JpaRepository<StudentBuilding, Long> {

    /**
     * 楼栋id查学生
     * @param buildingId 楼栋id
     * @return
     */
    List<StudentBuilding> findStudentBuildingsByBuildingId(Long buildingId);
}
