package com.djcao.mongo.repository;

import com.djcao.mongo.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/29
 */
@Repository
public interface LogRepository extends JpaRepository<Log,Long> {
}
