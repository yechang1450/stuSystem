package com.heaboy.provider.studentgrade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.course.entity.ClassCourse;
import com.heaboy.service.course.service.IClassCourseService;
import com.heaboy.service.studentgrade.entity.StudentGrade;
import com.heaboy.provider.studentgrade.mapper.StudentGradeMapper;
import com.heaboy.service.studentgrade.service.IStudentGradeService;
import com.heaboy.service.studentgrade.entity.StudentGradeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Service
public class StudentGradeServiceImpl extends ServiceImpl<StudentGradeMapper, StudentGrade> implements IStudentGradeService {

    @Autowired
    private IClassCourseService classCourseService;

    @Override
    public IPage<StudentGrade> index(Page<StudentGrade> page ,StudentGrade studentGrade){

        QueryWrapper<StudentGrade> queryWrapper = new QueryWrapper<StudentGrade>();
        if(!ObjectUtils.isEmpty(studentGrade.getStudentNo())) {
            queryWrapper = queryWrapper.like("studentNo",studentGrade.getStudentNo());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getCourseNo())) {
            queryWrapper = queryWrapper.like("courseNo",studentGrade.getCourseNo());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getScore())) {
            queryWrapper = queryWrapper.like("score",studentGrade.getScore());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getScorelevel())) {
            queryWrapper = queryWrapper.like("scorelevel",studentGrade.getScorelevel());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getAppraise())) {
            queryWrapper = queryWrapper.like("appraise",studentGrade.getAppraise());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getUsualGrades())) {
            queryWrapper = queryWrapper.like("usualGrades",studentGrade.getUsualGrades());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getUsualWeight())) {
            queryWrapper = queryWrapper.like("usualWeight",studentGrade.getUsualWeight());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getTestGrades())) {
            queryWrapper = queryWrapper.like("testGrades",studentGrade.getTestGrades());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getTestWeight())) {
            queryWrapper = queryWrapper.like("testWeight",studentGrade.getTestWeight());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getGrade())) {
            queryWrapper = queryWrapper.like("grade",studentGrade.getGrade());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getIsHang())) {
            queryWrapper = queryWrapper.like("isHang",studentGrade.getIsHang());
        }
        if(!ObjectUtils.isEmpty(studentGrade.getClassNo())) {
            queryWrapper = queryWrapper.like("classNo",studentGrade.getClassNo());
        }
        IPage<StudentGrade> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    /**添加一条学生成绩
     * @param studentGrade
     * @return 是否添加成功
     * @author 王啸威
     */
    @Override
    public boolean saveScore(StudentGrade studentGrade) {
        ClassCourse classCourse = classCourseService.getClassCourseByCourseNoAndClassNo(studentGrade.getCourseNo(), studentGrade.getClassNo());
        System.out.println(studentGrade.getClassNo());
        System.out.println(studentGrade.getCourseNo());
        if (classCourse == null){
            return false;
        }
        //设置平时成绩权重
        studentGrade.setUsualWeight(classCourse.getUsualWeight());
        //设置考试成绩权重
        studentGrade.setTestWeight(classCourse.getTestWeight());
        //设置总成绩
        studentGrade.setGrade(studentGrade.getUsualGrades()*studentGrade.getUsualWeight()+studentGrade.getTestGrades()*studentGrade.getTestWeight());
        //是否挂科
        if(studentGrade.getGrade() >= ClassCourse.IS_HANG){
            studentGrade.setIsHang(ClassCourse.NOT_HANG);
        }else {
            studentGrade.setIsHang(ClassCourse.HANG);
        }
        return this.save(studentGrade);
    }

    /**修改一条学生成绩
     * @param studentGrade
     * @return 是否修改成功
     */
    @Override
    public boolean updateScore(StudentGrade studentGrade) {
        //设置总成绩
        studentGrade.setGrade(studentGrade.getUsualGrades()*studentGrade.getUsualWeight()+studentGrade.getTestGrades()*studentGrade.getTestWeight());
        //是否挂科
        if(studentGrade.getGrade() >= 60){
            studentGrade.setIsHang(0);
        }else {
            studentGrade.setIsHang(1);
        }
        return this.updateById(studentGrade);
    }

    @Override
    public IPage<StudentGradeVo> indexPage(Page<StudentGradeVo> page, StudentGrade studentGrade, String userName) {
        IPage<StudentGradeVo> pageInfo = getBaseMapper().selectPageInfo(page,studentGrade,userName);
        return pageInfo;
    }
}


