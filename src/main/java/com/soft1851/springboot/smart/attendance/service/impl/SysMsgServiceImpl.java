package com.soft1851.springboot.smart.attendance.service.impl;

import com.soft1851.springboot.smart.attendance.model.entity.SysMsg;
import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;
import com.soft1851.springboot.smart.attendance.model.vo.MsgVo;
import com.soft1851.springboot.smart.attendance.repository.SysMsgRepository;
import com.soft1851.springboot.smart.attendance.service.SysMsgService;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Zeng
 * @ClassName SysMsgServiceImpl
 * @Description TOOD
 * @Date 2020/6/22
 * @Version 1.0
 **/
@Service
public class SysMsgServiceImpl implements SysMsgService {

    @Resource
    private SysMsgRepository sysMsgRepository;

    @Override
    public List<EntityVo> queryMsg(String toId) {
        List<Object> objects = sysMsgRepository.queryMsgById(toId);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, MsgVo.class);
        return entityVos;
    }

    @Override
    public SysMsg sendMsg(SysMsg msg) {
        SysMsg sysMsg = SysMsg.builder()
                .title(msg.getTitle())
                .content(msg.getContent())
                .fromId(msg.getFromId())
                .toId(msg.getToId())
                .deleteFlag(0)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .isRead(0)
                .build();
        return sysMsgRepository.save(sysMsg);
    }

    @Override
    public void deleteMsg(Long msgId) {
        Optional<SysMsg> optionalMsg = sysMsgRepository.findById(msgId);
        SysMsg msg = optionalMsg.get();
        msg.setDeleteFlag(1);
        sysMsgRepository.save(msg);
    }
}
