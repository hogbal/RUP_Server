package com.rup.rup_backend.repository;

import com.rup.rup_backend.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    // <[Entity], [Entity.PK]>
    Optional<UserInfo> findByNickname(String Nickname);
    Optional<UserInfo> findByEmailAndPassword(String Email, String Password);
    Optional<UserInfo> findByEmailAndCollegeAndMajor(String Email, String College, String Major);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_info U SET U.point = U.point + :point, U.count_recycle = U.count_recycle + :point WHERE U.uid = :uid", nativeQuery = true)
    void updateTotalPointAndRecycle(@Param("point")int point, @Param("uid")String uid) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_info U SET U.password = :password WHERE U.uid = :uid", nativeQuery = true)
    void updateTemporaryPassword(@Param("password")String tempPw, @Param("uid")String uid) throws Exception;

    @Transactional
    @Modifying
    @Query(value="UPDATE user_info U SET " +
            "U.email = :email," +
            "U.[assword = :password," +
            "U.nickname = :nickname," +
            "U.sex = :sex," +
            "U.birth = :birth," +
            "U.college = :college," +
            "U.major = :major" +
            " WHERE U.uid = :uid"
            , nativeQuery = true)
    void updateUserInfo(@Param("email")String email,
                        @Param("password")String password,
                        @Param("nickname")String nickname,
                        @Param("sex")String sex,
                        @Param("birth")String birth,
                        @Param("college")String college,
                        @Param("major")String major,
                        @Param("uid")String uid
                        ) throws Exception;

    @Transactional
    @Modifying
    @Query(value="DELETE FROM user_info WHERE uid = :uid", nativeQuery = true)
    void deleteUserInfo(@Param("uid")String uid);

}

