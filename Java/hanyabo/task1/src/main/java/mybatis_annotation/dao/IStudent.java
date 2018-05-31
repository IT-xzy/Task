package mybatis_annotation.dao;

import model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IStudent {

	@Select("SELECT * FROM entry_form")
	public List<Student> getStudentList();

	@Insert("INSERT INTO entry_form(name,qq, profession,join_date,school,online_id, daily_url,declaration,introducer,referee,counselor,description,city,review) VALUES(#{name}, #{qq}, #{profession}, #{join_date},#{school},#{online_id},#{daily_url},#{declaration},#{introducer},#{referee},#{counselor},#{description},#{city},#{review} )")
	public void insertStudent(Student Student);

	@Update("UPDATE entry_form SET name = #{name},qq = #{qq}, profession = #{profession}, join_date = #{join_date}, school = #{school}, online_id = #{online_id}, daily_url = #{daily_url}, declaration = #{declaration},introducer = #{introducer},referee = #{referee},counselor = #{counselor},description = #{description},city = #{city},review=#{review} WHERE id=#{id}")
	public void updateStudent(Student Student);

	@Delete("DELETE FROM entry_form WHERE id = #{id}")
	public void deleteStudent(Long StudentId);

	@Select("SELECT * FROM entry_form WHERE id = #{id}")
	public Student getStudent(Long id);
}
