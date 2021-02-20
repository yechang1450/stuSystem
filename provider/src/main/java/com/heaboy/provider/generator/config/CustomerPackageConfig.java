package com.heaboy.provider.generator.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.Data;

@Data
public class CustomerPackageConfig extends PackageConfig {
    private String entityParent = "com.heaboy";
    /**
     * Service包名
     */
    private String serviceParent = "com.heaboy";
    /**
     * Service Impl包名
     */
    private String serviceImplParent = "com.heaboy";
    /**
     * Mapper包名
     */
    private String mapperParent = "com.heaboy";
    /**
     * Mapper XML包名
     */
    private String xmlParent = "com.heaboy";
    /**
     * Controller包名
     */
    private String controllerParent = "com.heaboy";

    @Override
    public String getEntity() {
        return getEntityParent()+ StringPool.DOT+getModuleName()+StringPool.DOT+super.getEntity();
    }

    @Override
    public String getMapper() {
        return getMapperParent()+ StringPool.DOT+getModuleName()+StringPool.DOT+super.getMapper();
    }

    @Override
    public String getController() {
        return getControllerParent()+ StringPool.DOT+getModuleName()+StringPool.DOT+super.getController();
    }

    @Override
    public String getService() {
        return getServiceParent()+ StringPool.DOT+getModuleName()+StringPool.DOT+super.getService();
    }

    @Override
    public String getServiceImpl() {
        return getServiceImplParent()+ StringPool.DOT+getModuleName()+StringPool.DOT+super.getServiceImpl();
    }

    @Override
    public String getXml() {
        return getXmlParent()+ StringPool.DOT+getModuleName()+StringPool.DOT+super.getXml();
    }

    @Override
    public String getParent() {
        return "";
    }
}
