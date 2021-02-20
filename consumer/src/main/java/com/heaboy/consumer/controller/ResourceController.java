package com.heaboy.consumer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.entity.ResultCode;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.sys.entity.SysResource;
import com.heaboy.service.sys.service.ISysResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 项目权限资源控制类
 * 
 * @author 王震
 *
 */
@Slf4j
@RestController
@Api(value = "获取权限资源")
@ApiVersion(1)
@RequestMapping("/{version}/resource")
public class ResourceController {
	private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

	@Reference
	private ISysResourceService resourceService;

	@Autowired
	private UserInfoUtil userInfoUtil;

	@PreAuthorize("hasAuthority('/resource')")
	@ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
	@GetMapping("/findResource/{id}")
	public ResultJson findResource(@PathVariable Integer id) {
		SysResource resource = resourceService.getById(id);

		return ResultJson.ok(resource);
	}



	@PreAuthorize("hasAuthority('/resource')")
	@ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
	@PostMapping("/listResources/{currentPage}/{pageSize}")
	public ResultJson listResources(@RequestBody SysResource resource, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
//		resource.setAvailable(true);
		resource.setParentId(1L);
		IPage<SysResource> resourceList = resourceService.listPage(resource, new Page<>(currentPage, pageSize));
		return ResultJson.ok(resourceList);
	}

	@PreAuthorize("hasAuthority('/resource')")
	@ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
	@GetMapping("/loadResources/{parentId}")
	public ResultJson loadResources(@PathVariable long parentId) {
		List<SysResource> resourceList = resourceService.findByParentId(parentId);
		return ResultJson.ok(resourceList);
	}


	@PreAuthorize("hasAuthority('/resource')")
	@ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
	@PostMapping("/saveOrUpdate")
	public ResultJson saveOrUpdate(@RequestBody SysResource resource) {
		String userNo = userInfoUtil.getUserNo();
		System.out.println(userNo);
		logger.info(userNo);
		boolean flag = resourceService.saveOrUpdate(resource);
		if(flag){
			return ResultJson.ok();
		}
		return ResultJson.failure(ResultCode.BAD_REQUEST);
	}

	@PreAuthorize("hasAuthority('/resource/delete')")
	@ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
	@GetMapping("/delete")
	public ResultJson delete(@RequestParam Long[] ids) {

		List<SysResource> childResources = resourceService.listByParentId(ids);
		if(childResources.size() > 0){
			return ResultJson.failure(ResultCode.CHILD_DATA_EXIST);
		}

		boolean flag = resourceService.removeByIds(Arrays.asList(ids));
		if(flag){
			return ResultJson.ok();
		}

		return ResultJson.failure(ResultCode.BAD_REQUEST);
	}

}
