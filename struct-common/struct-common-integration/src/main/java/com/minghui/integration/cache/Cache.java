package com.ropeok.integration.cache;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 10:15 2018/5/16
 * @Modified By:
 */
public interface Cache<T> {


    boolean containSignature(Signature signature);

    void cacheObject(Signature signature, T t);

    T getObject(Signature signature);

    class Signature{

        private String id;

        private Class<?>[] params;

        public Signature(String id,Class<?>[] params){
            this.id = id;
            this.params = params;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Class<?>[] getParams() {
            return params;
        }

        public void setParams(Class<?>[] params) {
            this.params = params;
        }
    }

}
