package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.model.entity.SysMsg;
import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;

import java.util.List;

/**
 * @author ZENG
 */
public interface SysMsgService {

    /**
     * 查用户消息
     * @param toId
     * @return
     */
    List<EntityVo> queryMsg(String toId);

    /**
     * 发消息
     * @param msg
     * @return
     */
    SysMsg sendMsg(SysMsg msg);

    /**
     * 逻辑删除msg
     * @param msgId
     */
    void deleteMsg(Long msgId);
}
