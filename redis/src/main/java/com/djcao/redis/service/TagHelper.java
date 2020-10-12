package com.djcao.redis.service;


import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import org.redisson.api.RScript;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/6/21
 */
@Component
public class TagHelper {

    @Autowired
    private RedissonClient redissonClient;

    public Boolean tag(Long userId, Long tagId) {
        RScript script = redissonClient.getScript();
        return script.eval(RScript.Mode.READ_WRITE, "redis.call('sadd',KEYS[1],ARGV[1]) redis.call"
                + "('sadd',"
                + "KEYS[2],ARGV[2]) return 1",
            RScript.ReturnType.BOOLEAN,
            Lists.newArrayList("users:tags" + userId, "tags:" + tagId), tagId, userId);
    }

    public Boolean removeTag(Long userId, Long tagId) {
        RScript script = redissonClient.getScript();
        return script.eval(RScript.Mode.READ_WRITE, "redis.call('srem',KEYS[1],ARGV[1]) redis.call"
                + "('srem',"
                + "KEYS[2],ARGV[2]) return 1",
            RScript.ReturnType.BOOLEAN,
            Lists.newArrayList("users:tags" + userId, "tags:" + tagId), tagId, userId);
    }

    public Set<Long> commonInterestTag(List<Long> userIds)  {
        RSet<Long> set = redissonClient.getSet("users:tags"+userIds.get(0));
        return set.readIntersection(userIds.stream().map(id -> "users:tags"+id).toArray(String[]::new));
    }

}
