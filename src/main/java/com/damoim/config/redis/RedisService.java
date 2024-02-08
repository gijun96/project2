//package com.damoim.config.redis;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.Duration;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//@Component
//@RequiredArgsConstructor
//public class RedisService {
//
//    private final RedisTemplate<String, Object> redisTemplate;
//
//
////    setValue() : key와 data 를 Redis에 저장한다. 만약 데이터에 만료시간을 설정하고 싶다면
////                  세번쨰 파라미터로 Duration 객체를 전달한다.
////    getValues() : key를 파라미터로 받아 key를 기반으로 데이터를 조회한다.
////    deleteValues(): key를 파라미터로 받아 key를 기반으로 데이터를 삭제한다.
////    checkExistsValues(): 조회하려는 데이터가 없으면 false를 반환한다.
//    public void setValues(String key, String data){
//        ValueOperations<String, Object> values= redisTemplate.opsForValue();
//        values.set(key, data);
//    }
//
//    public void setValues(String key, String data, Duration duration){
//        ValueOperations<String, Object> values = redisTemplate.opsForValue();
//        values.set(key, data, duration);
//    }
//
//    @Transactional(readOnly = true)
//    public String getValues(String key){
//        ValueOperations<String, Object> values = redisTemplate.opsForValue();
//        if(values.get(key) == null){
//            return "false";
//        }
//        return (String)values.get(key);
//    }
//
//    public void deleteValues(String key){
//        redisTemplate.delete(key);
//    }
//
//    public void expireValues(String key, int timeout) {
//        redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
//    }
//
//    public void setHashOps(String key, Map<String, String> data) {
//        HashOperations<String, Object, Object> values = redisTemplate.opsForHash();
//        values.putAll(key, data);
//    }
//
//    @Transactional(readOnly = true)
//    public String getHashOps(String key, String hashKey) {
//        HashOperations<String, Object, Object> values = redisTemplate.opsForHash();
//        return Boolean.TRUE.equals(values.hasKey(key, hashKey)) ? (String) redisTemplate.opsForHash().get(key, hashKey) : "";
//    }
//
//    public void deleteHashOps(String key, String hashKey) {
//        HashOperations<String, Object, Object> values = redisTemplate.opsForHash();
//        values.delete(key, hashKey);
//    }
//
//    public boolean checkExistsValue(String value) {
//        return !value.equals("false");
//    }
//
//
//}
