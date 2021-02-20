package com.heaboy.provider.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.common.util.Utility;
import com.heaboy.service.student.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.student.mapper.StudentMapper;
import com.heaboy.service.student.service.IStudentService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public IPage<Student> index(Page<Student> page ,Student student){

        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        if(!ObjectUtils.isEmpty(student.getStudentNo())) {
            queryWrapper = queryWrapper.like("studentNo",student.getStudentNo());
        }
        if(!ObjectUtils.isEmpty(student.getStudentName())) {
            queryWrapper = queryWrapper.like("studentName",student.getStudentName());
        }
        if(!ObjectUtils.isEmpty(student.getClassNo())) {
            queryWrapper = queryWrapper.like("classNo",student.getClassNo());
        }
        if(!ObjectUtils.isEmpty(student.getSex())) {
            queryWrapper = queryWrapper.like("sex",student.getSex());
        }
        if(!ObjectUtils.isEmpty(student.getPhoneNumber())) {
            queryWrapper = queryWrapper.like("phoneNumber",student.getPhoneNumber());
        }
        if(!ObjectUtils.isEmpty(student.getStageId())) {
            queryWrapper = queryWrapper.like("stageId",student.getStageId());
        }
        if(!ObjectUtils.isEmpty(student.getStatus())) {
            queryWrapper = queryWrapper.like("status",student.getStatus());
        }
        if(!ObjectUtils.isEmpty(student.getRecommendCode())) {
            queryWrapper = queryWrapper.like("recommendCode",student.getRecommendCode());
        }
        if(!ObjectUtils.isEmpty(student.getSelfrecommendCode())) {
            queryWrapper = queryWrapper.like("selfrecommendCode",student.getSelfrecommendCode());
        }
        if(!ObjectUtils.isEmpty(student.getLateTimes())) {
            queryWrapper = queryWrapper.like("lateTimes",student.getLateTimes());
        }
        if(!ObjectUtils.isEmpty(student.getTruancyTimes())) {
            queryWrapper = queryWrapper.like("truancyTimes",student.getTruancyTimes());
        }
        if(!ObjectUtils.isEmpty(student.getWorkplace())) {
            queryWrapper = queryWrapper.like("workplace",student.getWorkplace());
        }
        if(!ObjectUtils.isEmpty(student.getPersonalSignature())) {
            queryWrapper = queryWrapper.like("personalSignature",student.getPersonalSignature());
        }
        IPage<Student> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public List<Student> listByClassNo(String classNo) {
        return getBaseMapper().selectByClassNo(classNo);
    }
    @Override
    public Student insertSelective(Student student) {
        if(student.getStudentNo()==null){
            student.setStudentNo(student.getPhoneNumber());
        }
        if(student.getStageId()==null){
            student.setStageId(1);
        }
        if(student.getStatus()==null){
            student.setStatus(1);
        }
        if(student.getSelfrecommendCode()==null){
            student.setSelfrecommendCode(Utility.getRandomStrByNum(4));
        }
        baseMapper.insertSelective(student);
        return  student;
    }
}
