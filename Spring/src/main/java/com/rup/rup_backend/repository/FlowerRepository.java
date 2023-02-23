package com.rup.rup_backend.repository;

import com.rup.rup_backend.entity.FlowerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlowerRepository extends JpaRepository<FlowerInfo, Integer> {
    @Query(value = "SELECT * FROM flower_record WHERE uid = :uid ORDER BY flower_grown_level", nativeQuery = true)
    List<FlowerInfo> findFlowerInfoByUid(@Param("uid")String uid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO flower_record (uid, flower, flower_nickname) VALUES (:uid, :flower, :flowerNickname)", nativeQuery = true)
    void insertFlower(@Param("uid")String uid, @Param("flower")String flower, @Param("flowerNickname")String flowerNickname);

    @Transactional
    @Modifying
    @Query(value = "UPDATE flower_record SET flower_grown_level = flower_grown_level + :point WHERE uid = :uid AND flower_grown_level < :maxGrownLevel", nativeQuery = true)
    void updateFlowerGrownLevel(@Param("point")int point, @Param("uid")String uid, @Param("maxGrownLevel")int maxGrownLevel);
}
