package com.juzheng.smart.tourism.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * redis工具类
 *@author juzheng
*/ 
public class RedisClientServer{

   private  static  final  Logger   logger = LoggerFactory.getLogger(RedisClientServer.class);

   private  static  JedisPool  jedisPool = null;

   private  static Jedis jedis = null;

   public  static Jedis jedis_object = null;

   private static String host = "101.132.139.188";
   private static String password = "960921";
   private static Integer port = 6379;


   static{
      if(jedisPool == null){
         JedisPoolConfig  config = new JedisPoolConfig(); 
         //设置最大连接数
         config.setMaxTotal(500);
         //设置最大空闲数
         config.setMaxIdle(20);
         //设置最小空闲数
         config.setMinIdle(8);
         //设置超时时间
         config.setMaxWaitMillis(3000);
         //Idle时进行连接扫描
         config.setTestWhileIdle(true);
         //表示idle object evitor两次扫描之间要sleep的毫秒数
         config.setTimeBetweenEvictionRunsMillis(30000);
         //表示idle object evitor每次扫描的最多的对象数
         config.setNumTestsPerEvictionRun(10);
         //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor
         //扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
         config.setMinEvictableIdleTimeMillis(60000);
         //初始化连接池
         jedisPool = new JedisPool(config, host, port);
         jedis_object = new   Jedis( host, port);
      }
   }

   private  RedisClientServer() {

   }

   private static Jedis  getJedisInstance(){

      try { 
         if(null == jedis){
            jedis = jedisPool.getResource();
            jedis.auth(password);
         }
      } catch (Exception e) {
         logger.error("实例化jedis失败.........", e);
      }
      return jedis;
   }

   /**
    * 向缓存中设置字符串内容 
    *@author juzheng
    *@date 
    */
   public static boolean set(String key, String value) throws Exception {
      Jedis jedis = null;
      try {
         jedis = getJedisInstance();
         jedis.set(key, value);
         return true;
      } catch (Exception e) {
         logger.error("redis set方法失败...key="+key+"  value="+value, e);
      } finally {
         jedisPool.close();
      }
      return false;
   }

   /**
    * 向缓存中设置字符串内容 ,设置过期时间
    *@author juzheng
*@date 
*/
   public static boolean set(String key, String value,Integer seconds) throws Exception {
      Jedis jedis = null;
      try {
         jedis = getJedisInstance();
         jedis.set(key, value);
         jedis.expire(key, seconds);
         return true;
      } catch (Exception e) {
         logger.error("redis set方法失败...key="+key+"  value="+value, e);
      } finally {
         jedisPool.close();
      }
      return false;
   }

   /**
    * 根据key 获取内容
    *@author juzheng
    *@date 
    */
   public static Object get(String key) {
      Jedis jedis = null;
      try {
         jedis = getJedisInstance();
         Object value = jedis.get(key);
         return value;
      } catch (Exception e) {
         logger.error("redis get方法失败...key="+key);
      } finally {
         jedisPool.close();
      }
      return null;
   }

   /**
    * 删除缓存中得对象，根据key
    *@author juzheng
    *@date 
    */
   public static boolean del(String key) {
      Jedis jedis = null;
      try {
         jedis = getJedisInstance();
         jedis.del(key);
         return true;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         jedisPool.close();
      }
      return false;
   }

   /**
    * 根据key 获取对象
    *@author juzheng
    *@date 
    */
   public static <T> T get(String key, Class<T> clazz) {
      Jedis jedis = null;
      try {
         jedis = getJedisInstance();
         String value = jedis.get(key);
         return JSON.parseObject(value, clazz);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         jedisPool.close();
      }
      return null;
   }

   /**
    *  设置key过期
    *@author 
    *@date 
    */
   public  static   boolean  expire(String key,int seconds){
      Jedis jedis = null;
      try {
         jedis = getJedisInstance();
         jedis.expire(key, seconds);
         return  true;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         jedisPool.close();
      }
      return false;
   }

   /**
    * 判断是否存在key
    *@author 
    *@date 
    */
   public static Boolean exists(String key){
      Jedis jedis = null;
      try {
         jedis = getJedisInstance();
         return jedis.exists(key);
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }finally {
         jedisPool.close();
      }
   }

}
