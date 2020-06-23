package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ZENG
 */
public interface SysMsgRepository extends JpaRepository<SysMsg, Long> {

    /**
     * 查询用户消息
     * @param toId
     * @return
     */
    @Query(value = "SELECT m.pk_message_id,m.title,m.content,m.is_read,m.gmt_create,u.sys_user_name " +
            "FROM sys_msg m LEFT JOIN sys_user u " +
            "ON m.from_id=u.pk_sys_user_id " +
            "WHERE m.to_id=?1 AND m.delete_flag=0 ORDER BY m.gmt_create DESC ", nativeQuery = true)
    List<Object> queryMsgById(String toId);
}
