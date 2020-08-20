package com.ropeok.integration.locker.cache;

import com.ropeok.integration.annotation.VersionLocker;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 19:15 2018/5/9
 * @Modified By:
 */
@Slf4j
public class LocalVersionLockerCache implements VersionLockerCache {

    private ConcurrentHashMap<String,ConcurrentHashMap<Signature,VersionLocker>> caches = new ConcurrentHashMap();

    @Override
    public boolean containSignature(Signature signature) {
        String nameSpace = getNameSpace(signature);
        ConcurrentHashMap<Signature,VersionLocker> cache = caches.get(nameSpace);
        if(cache == null || cache.isEmpty()){
            return false;
        }
        boolean flag = cache.containsKey(signature);
        if(flag && log.isDebugEnabled()){
            log.debug("the method "+nameSpace+signature.getId()+"is hit in cache");
        }
        return flag;
    }

    private String getNameSpace(Signature signature) {
        String id = signature.getId();
        int pos = id.lastIndexOf(".");
        return id.substring(0,pos);
    }

    @Override
    public void cacheObject(Signature vm, VersionLocker locker) {
        String nameSpace = getNameSpace(vm);
        ConcurrentHashMap<Signature,VersionLocker> cache = caches.get(nameSpace);
        if(cache == null || cache.isEmpty()){
            cache = new ConcurrentHashMap<>();
            cache.put(vm,locker);
            caches.put(nameSpace,cache);
            if(log.isDebugEnabled()){
                log.debug("Locker debug info ==>"+nameSpace+": "+vm.getId()+"is cached.");
            }
        }else{
            cache.put(vm,locker);
        }
    }

    @Override
    public VersionLocker getObject(Signature vm) {
        String nameSpace = getNameSpace(vm);
        ConcurrentHashMap<Signature,VersionLocker> cache = caches.get(nameSpace);
        if(cache == null || cache.isEmpty()){
            return null;
        }
        return cache.get(vm);
    }
}
