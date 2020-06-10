package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZENG
 */
public interface SysUserRepository extends JpaRepository<SysUser, String> {
}
