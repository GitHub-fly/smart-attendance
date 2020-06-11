package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.UserBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Zeng
 * @ClassName UserBuildingRepository
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/

public interface UserBuildingRepository extends JpaRepository<UserBuilding, Long> {

    /**
     * 查宿管所管楼层id
     * @param userId
     * @return
     */
    UserBuilding findUserBuildingByUserId(String userId);
}
