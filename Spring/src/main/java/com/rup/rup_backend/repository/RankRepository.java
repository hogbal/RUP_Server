package com.rup.rup_backend.repository;

import com.rup.rup_backend.entity.RankInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankRepository extends JpaRepository<RankInfo, String> {
   @Query(value="SELECT nickname, RANK() OVER (ORDER BY(totalpoint) DESC) AS rank, college, SUM(point) AS totalpoint FROM user_info GROUP BY(college) ORDER BY(rank)", nativeQuery = true)
   List<RankInfo> findRankGroupByCollege();

   @Query(value="SELECT nickname, RANK() OVER (ORDER BY(point) DESC) AS rank, college, point AS totalpoint FROM user_info WHERE college = :college ORDER BY(rank)", nativeQuery = true)
   List<RankInfo> findRankAllByCollege(@Param("college")String college);
}
