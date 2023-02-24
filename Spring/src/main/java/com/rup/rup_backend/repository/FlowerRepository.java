package com.rup.rup_backend.repository;

import com.rup.rup_backend.entity.FlowerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlowerRepository extends JpaRepository<FlowerInfo, Integer> {
    // @Query(value = "SELECT * FROM flower_record WHERE uid = :uid ORDER BY flower_grown_level", nativeQuery = true)
    // List<FlowerInfo> findFlowerInfoByUid(@Param("uid")String uid);

    @Query(value = "SELECT * FROM flower_record WHERE uid = :uid and flower_state = 1", nativeQuery = true)
    List<FlowerInfo> findFlowerEndByUid(@Param("uid")String uid);

    @Query(value = "SELECT * FROM flower_record WHERE uid = :uid and flower_state = 0", nativeQuery = true)
    List<FlowerInfo> findFlowerLastByUid(@Param("uid")String uid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO flower_record (uid, flower, flower_nickname) VALUES (:uid, :flower, :flowerNickname)", nativeQuery = true)
    void insertFlower(@Param("uid")String uid, @Param("flower")String flower, @Param("flowerNickname")String flowerNickname);

    @Transactional
    @Modifying
    @Query(value = "UPDATE flower_record SET flower_state = 1 WHERE uid = :uid", nativeQuery = true)
    void updateFlowerState(@Param("uid")String uid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE flower_record F SET F.flower_point = F.flower_point + :point WHERE uid = :uid and flower_state = 0 ", nativeQuery = true)
    void updateFlowerPoint(@Param("uid")String uid,  @Param("point")int point);
}
