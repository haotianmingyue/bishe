//package com.haotian.demo.redis;
//
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
//import javax.annotation.Resource;
//
//public abstract class AbstractBaseRedisDao<K, V> {
//
//    @Resource(name = "redisTemplate")
//    protected RedisTemplate<K, V> redisTemplate;
//
//    /**
//     * 设置redisTemplate
//     *
//     * @param redisTemplate
//     */
//    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    /**
//     * 获取 RedisSerializer
//     */
//    protected RedisSerializer<String> getRedisSerializer() {
//        return redisTemplate.getStringSerializer();
//    }
//}
