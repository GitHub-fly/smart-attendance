package com.soft1851.springboot.smart.attendance.controller;

import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import com.soft1851.springboot.smart.attendance.model.dto.QueryDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysMsg;
import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;
import com.soft1851.springboot.smart.attendance.service.SysMsgService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zeng
 * @ClassName SysMsgController
 * @Description TOOD
 * @Date 2020/6/22
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/msg")
public class SysMsgController {

    @Resource
    private SysMsgService sysMsgService;

    @PostMapping("/info")
    @ApiOperation(value = "查询消息", notes = "")
    public List<EntityVo> queryMsg(@RequestBody QueryDto queryDto) {
        return sysMsgService.queryMsg(queryDto.getField1());
    }

    @PostMapping("/send")
    @ApiOperation(value = "发送消息", notes = "")
    public SysMsg sendMsg(@RequestBody SysMsg sysMsg) {
        return sysMsgService.sendMsg(sysMsg);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除消息", notes = "")
    public ResponseResult deleteMsg(@RequestBody QueryDto queryDto) {
        sysMsgService.deleteMsg(queryDto.getField2());
        return ResponseResult.success("删除成功");
    }
}
