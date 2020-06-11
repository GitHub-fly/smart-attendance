package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.DormitoryStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Zeng
 * @ClassName DormitoryStudentRepository
 * @Description TOOD
 * @Date 2020/6/11
 * @Version 1.0
 **/
public interface DormitoryStudentRepository extends JpaRepository<DormitoryStudent, Long> {

    /**
     * 学生id查宿舍id
     * @param stuId
     * @return
     */
    @Query(value = "SELECT dormitory_id FROM dormitory_student WHERE user_id IN ?1 GROUP BY dormitory_id", nativeQuery = true)
    List<Long> queryDormitoryId(List<String> stuId);

}
