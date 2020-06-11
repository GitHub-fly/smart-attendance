package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysDormitory;
import com.soft1851.springboot.smart.attendance.model.vo.DormitoryVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author Zeng
 * @ClassName SysDormitoryRepository
 * @Description TOOD
 * @Date 2020/6/11
 * @Version 1.0
 **/
public interface SysDormitoryRepository extends JpaRepository<SysDormitory, Long> {

    /**
     * 根据宿舍id查宿舍信息
     * @param dormitoryId
     * @return
     */
    @Query(value = "SELECT d.name, d.pk_sys_dormitory_id AS dormitory_id, c.teacher_name, c.teacher_phone, c.name AS clazz_name " +
            "FROM sys_dormitory d " +
            "LEFT JOIN sys_clazz c ON d.clazz_id=c.pk_sys_clazz_id " +
            "WHERE d.pk_sys_dormitory_id IN ?1 ",nativeQuery = true)
    List<Object> findDormitoryByIds(List<Long> dormitoryId);

    /**
     * 根据宿舍id查看宿舍内成员打卡信息
     * @param dormitoryId
     * @return
     */
    @Query(value = "SELECT ds.bed_number,ds.user_id,u.sys_user_name,u.is_attendance " +
            "FROM sys_dormitory d " +
            "LEFT JOIN dormitory_student ds ON d.pk_sys_dormitory_id=ds.dormitory_id " +
            "LEFT JOIN sys_user u ON u.pk_sys_user_id=ds.user_id " +
            "WHERE d.pk_sys_dormitory_id=?1 ", nativeQuery = true)
    List<Object> findStuCheckInfo(Long dormitoryId);

}
