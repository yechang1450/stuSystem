package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public IPage<${entity}> index(Page<${entity}> page ,${entity} ${entity?uncap_first}){

        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<${entity}>();
        <#list table.fields as field >
        <#if (field.propertyName != "id" && field.propertyName != "createTime" && field.propertyName != "updateTime") >
        if(!ObjectUtils.isEmpty(${entity?uncap_first}.get${field.propertyName?cap_first}())) {
            queryWrapper = queryWrapper.like("${field.name}",${entity?uncap_first}.get${field.propertyName?cap_first}());
        }
        </#if>
        </#list>
        IPage<${entity}> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
