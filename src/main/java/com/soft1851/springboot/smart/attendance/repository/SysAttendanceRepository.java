package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZENG
 */
public interface SysAttendanceRepository extends JpaRepository<SysAttendance, Integer> {
}
