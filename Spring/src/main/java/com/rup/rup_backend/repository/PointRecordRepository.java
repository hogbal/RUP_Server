package com.rup.rup_backend.repository;

import com.rup.rup_backend.entity.Notice;
import com.rup.rup_backend.entity.PointRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface PointRecordRepository extends JpaRepository<PointRecord, Integer> {
    @Query(value = "SELECT * FROM point_record P WHERE P.uid = :uid ORDER BY date DESC LIMIT 20", nativeQuery = true)
    List<PointRecord> findPointRecord(@Param("uid")String uid);

    @Query(value = "SELECT idx, uid, date_format(Date, '%Y-%m-%d') AS date, SUM(point) as point FROM point_record WHERE uid = :uid GROUP BY (date_format(Date, '%Y-%m-%d')) ORDER BY date DESC", nativeQuery = true)
    List<PointRecord> findCalendarDate(@Param("uid")String uid);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO point_record(uid, point) VALUES (:uid, :point)", nativeQuery = true)
    void insertPointRecord(@Param("uid")String uid, @Param("point")int point);
}
