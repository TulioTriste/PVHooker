package me.tulio.pvhooker.cache;

import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheInfo {

    public static CacheBuilder<Object, Object> cacheInfo = CacheBuilder.newBuilder().expireAfterAccess(5L, TimeUnit.MINUTES);
}
