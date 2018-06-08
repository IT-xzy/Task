package dao.mapper;

import model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
/*
* mybatis注解操作数据库测试
*
* Mapper接口类
*
* 关联目录：
*
* java/service/下的  Service和ServiceImpl  ServiceImpl调用
*
* 测试类：
*
* java/action/MybatisAnnotationAction
*
* 使用Annotation 方式，动态语句比较麻烦，但是基本同xml是差不离的，基本上是吧xml里的写法在方法上@
*
* */

//@Repository
@Mapper
public interface StudentAnnotationMapper {

    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "create_at",property = "create_at"),
            @Result(column = "update_at",property = "update_at"),
            @Result(column = "name",property = "name"),
            @Result(column = "qq",property = "qq"),
            @Result(column = "type",property = "type"),
            @Result(column = "start_time",property = "strTime"),
            @Result(column = "school",property = "school"),
            @Result(column = "stu_num",property = "stuNum"),
            @Result(column = "daily_link",property = "dailyLink"),
            @Result(column = "pro",property = "pro"),
            @Result(column = "brother",property = "brother"),
            @Result(column = "user_id",property = "userId"),
    })
    public Student selectById(int id);


    @Select({"<script>",
            "SELECT * FROM student",
            "WHERE 1=1",
            "<if test='id!=null and id!=0'>",
            "AND id = #{id}",
            "</if>",
            "<if test='name!=null'>",
            "AND name like '%${name}%'",
            "</if>",
            "<if test='stuNum!=0'>",
            "AND stu_num like '%${stuNum}%'",
            "</if>",
            "</script>"})
    @ResultMap("studentAnnotationMapper")
    public List<Student> findByStudent(Student student);

    @Insert("INSERT INTO student (create_at,update_at,name,qq,type,start_time,school,stu_num,daily_link,pro,brother,user_id) values " +
            "        (#{create_at,jdbcType=BIGINT}," +
            "        #{update_at,jdbcType=BIGINT}," +
            "        #{name,jdbcType=VARCHAR}," +
            "        #{qq,jdbcType=BIGINT}," +
            "        #{type,jdbcType=INTEGER}," +
            "        #{startTime,jdbcType=VARCHAR}," +
            "        #{school,jdbcType=VARCHAR}," +
            "        #{stuNum,jdbcType=INTEGER}," +
            "        #{dailyLink,jdbcType=VARCHAR}," +
            "        #{pro,jdbcType=VARCHAR}," +
            "        #{brother,jdbcType=VARCHAR}," +
            "        #{userId,jdbcType=INTEGER})")
    int insertOne(Student student);

    @Insert({"<script>",
            "INSERT INTO student (create_at,update_at,name,qq,type,start_time,school,stu_num,daily_link,pro,brother,user_id) values " +
            "<foreach  item='item' collection='list' separator=',' index = 'index' close=';'>" +
                    "(#{item.create_at,jdbcType=BIGINT}," +
                    "#{item.update_at,jdbcType=BIGINT}," +
                    "#{item.name,jdbcType=VARCHAR}," +
                    "#{item.qq,jdbcType=BIGINT}," +
                    "#{item.type,jdbcType=INTEGER}," +
                    "#{item.startTime,jdbcType=VARCHAR}," +
                    "#{item.school,jdbcType=VARCHAR}," +
                    "#{item.stuNum,jdbcType=INTEGER}," +
                    "#{item.dailyLink,jdbcType=VARCHAR}," +
                    "#{item.pro,jdbcType=VARCHAR}," +
                    "#{item.brother,jdbcType=VARCHAR}," +
                    "#{item.userId,jdbcType=INTEGER})" +
                    "</foreach>"+
            "</script>"})
    @ResultMap("studentAnnotationMapper")
    int insertList(List<Student> students);


}
