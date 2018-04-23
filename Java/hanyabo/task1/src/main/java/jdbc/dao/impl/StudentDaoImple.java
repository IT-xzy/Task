package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.dao.StudentDao;
import jdbc.util.DBCPUtils;
import model.Student;

public class StudentDaoImple implements StudentDao {

	private Connection connection = null;
	private PreparedStatement ptmt;
	private List<Student> result;
	private ResultSet rs;

	public void addStudent(Student student) throws Exception {

		try {
			connection = jdbc.util.DBCPUtils.getConnection();
			String sql = "" + "insert into entry_form"
					+ " (name,qq,profession,join_date,school,online_id,"
					+ " daily_url,declaration,introducer,referee,counselor,"
					+ "description,city,review)" + " values ("
					+ " ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ptmt = connection.prepareStatement(sql);

			ptmt.setString(1, student.getName());
			ptmt.setString(2, student.getQq());
			ptmt.setString(3, student.getProfession());
			ptmt.setDate(4, new Date(student.getJoin_date().getTime()));
			ptmt.setString(5, student.getSchool());
			ptmt.setString(6, student.getOnline_id());
			ptmt.setString(7, student.getDaily_url());
			ptmt.setString(8, student.getDeclaration());
			ptmt.setString(9, student.getIntroducer());
			ptmt.setString(10, student.getReferee());
			ptmt.setString(11, student.getCounselor());
			ptmt.setString(12, student.getDescription());
			ptmt.setString(13, student.getCity());
			ptmt.setString(14, student.getReview());
			System.out.println(ptmt);
			ptmt.execute();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			DBCPUtils.release(ptmt);
			DBCPUtils.release(connection);
		}

	}

	public void updateStudent(Student student) throws Exception {
		try {
			Connection connection = DBCPUtils.getConnection();
			String sql = ""
					+ " update entry_form"
					+ " set name=?,qq=?,profession=?,join_date=?,school=?,online_id=?,"
					+ " daily_url=?,declaration=?,introducer=?,referee=?,counselor=?,"
					+ " description=?,city=?,review=?" + " where id=?";
			PreparedStatement ptmt = connection.prepareStatement(sql);

			ptmt.setString(1, student.getName());
			ptmt.setString(2, student.getQq());
			ptmt.setString(3, student.getProfession());
			ptmt.setDate(4, new Date(student.getJoin_date().getTime()));
			ptmt.setString(5, student.getSchool());
			ptmt.setString(6, student.getOnline_id());
			ptmt.setString(7, student.getDaily_url());
			ptmt.setString(8, student.getDeclaration());
			ptmt.setString(9, student.getIntroducer());
			ptmt.setString(10, student.getReferee());
			ptmt.setString(11, student.getCounselor());
			ptmt.setString(12, student.getDescription());
			ptmt.setString(13, student.getCity());
			ptmt.setString(14, student.getReview());
			ptmt.setLong(15, student.getId());

			System.out.println(ptmt);
			ptmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DBCPUtils.release(ptmt);
			DBCPUtils.release(connection);
		}

	}

	public void delStudent(Long id) throws Exception {
		try {
			Connection connection = DBCPUtils.getConnection();
			String sql = "" + " delete from entry_form" + " where id=?";
			PreparedStatement ptmt = connection.prepareStatement(sql);

			ptmt.setLong(1, id);

			System.out.println(ptmt);

			ptmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DBCPUtils.release(ptmt);
			DBCPUtils.release(connection);
		}

	}

	@SuppressWarnings("finally")
	public List<Student> query() throws Exception {
		try {
			result = new ArrayList<Student>();

			Connection conn = DBCPUtils.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select id, name,profession from entry_form  ");

			PreparedStatement ptmt = conn.prepareStatement(sb.toString());

			ResultSet rs = ptmt.executeQuery();

			Student student = null;
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getLong("id"));
				student.setName(rs.getString("name"));
				student.setProfession(rs.getString("profession"));
				result.add(student);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DBCPUtils.release(rs);
			DBCPUtils.release(ptmt);
			DBCPUtils.release(connection);

			return result;
		}

	}

	public List<Student> query(String name) throws Exception {
		List<Student> result = new ArrayList<Student>();

		Connection conn = DBCPUtils.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from entry_form  ");

		sb.append(" where name like ?");

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%" + name + "%");
		ResultSet rs = ptmt.executeQuery();

		Student student = null;
		while (rs.next()) {
			student = new Student();
			student.setId(rs.getLong("id"));
			student.setCreate_at(rs.getLong("create_at"));
			student.setUpdate_at(rs.getLong("update_at"));
			student.setName(rs.getString("name"));
			student.setQq(rs.getString("qq"));
			student.setProfession(rs.getString("profession"));
			student.setJoin_date(rs.getDate("join_date"));
			student.setSchool(rs.getString("school"));
			student.setOnline_id(rs.getString("online_id"));
			student.setDaily_url(rs.getString("daily_url"));
			student.setDeclaration(rs.getString("declaration"));
			student.setIntroducer(rs.getString("introducer"));
			student.setReferee(rs.getString("referee"));
			student.setCounselor(rs.getString("counselor"));
			student.setDescription(rs.getString("description"));
			student.setCity(rs.getString("city"));
			student.setReview(rs.getString("review"));

			result.add(student);
		}
		return result;
	}

	@SuppressWarnings("finally")
	public List<Student> query(List<Map<String, Object>> params)
			throws Exception {
		try {
			result = new ArrayList<Student>();

			Connection conn = DBCPUtils.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from entry_form where ");

			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					Map<String, Object> map = params.get(i);
					sb.append(map.get("name") + " " + map.get("rela") + " '"
							+ map.get("value") + "'; ");
				}
			}

			PreparedStatement ptmt = conn.prepareStatement(sb.toString());

			System.out.println(sb.toString());
			ResultSet rs = ptmt.executeQuery();

			Student student = null;
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getLong("id"));
				student.setCreate_at(rs.getLong("create_at"));
				student.setUpdate_at(rs.getLong("update_at"));
				student.setName(rs.getString("name"));
				student.setQq(rs.getString("qq"));
				student.setProfession(rs.getString("profession"));
				student.setJoin_date(rs.getDate("join_date"));
				student.setSchool(rs.getString("school"));
				student.setOnline_id(rs.getString("online_id"));
				student.setDaily_url(rs.getString("daily_url"));
				student.setDeclaration(rs.getString("declaration"));
				student.setIntroducer(rs.getString("introducer"));
				student.setReferee(rs.getString("referee"));
				student.setCounselor(rs.getString("counselor"));
				student.setDescription(rs.getString("description"));
				student.setCity(rs.getString("city"));
				student.setReview(rs.getString("review"));

				result.add(student);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DBCPUtils.release(rs);
			DBCPUtils.release(ptmt);
			DBCPUtils.release(connection);

			return result;
		}

	}

	public Student getStudent(Long id) throws Exception {
		Student student = null;
		Connection connection = DBCPUtils.getConnection();
		String sql = "" + "select * from entry_form" + " where id=?";
		PreparedStatement ptmt = connection.prepareStatement(sql);

		ptmt.setLong(1, id);

		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			student = new Student();
			student.setId(rs.getLong("id"));
			student.setCreate_at(rs.getLong("create_at"));
			student.setUpdate_at(rs.getLong("update_at"));
			student.setName(rs.getString("name"));
			student.setQq(rs.getString("qq"));
			student.setProfession(rs.getString("profession"));
			student.setJoin_date(rs.getDate("join_date"));
			student.setSchool(rs.getString("school"));
			student.setOnline_id(rs.getString("online_id"));
			student.setDaily_url(rs.getString("daily_url"));
			student.setDeclaration(rs.getString("declaration"));
			student.setIntroducer(rs.getString("introducer"));
			student.setReferee(rs.getString("referee"));
			student.setCounselor(rs.getString("counselor"));
			student.setDescription(rs.getString("description"));
			student.setCity(rs.getString("city"));
			student.setReview(rs.getString("review"));
		}

		return student;
	}

}
