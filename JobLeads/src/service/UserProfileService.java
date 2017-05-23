package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dbconnection.Database;
import dbconnection.IDatabase;
import model.User;

public class UserProfileService {
	private IDatabase database = Database.getInstance();

	public int saveUser(User user) {
		int userId = 0;
		try {
			String sql = "INSERT INTO users (userid, fullname, gender, state, city, street,zipcode, birthyear, email, password, datecreated, datecreated "
					+ ") VALUES ('" + user.getUserId() + "','" + user.getName() + "','" + user.getGender() + "','"
					+ user.getState() + "','" + user.getCity() + "'," + user.getStreet() + ",'" + user.getZip()
					+ user.getBirthYear() + "','" + user.getEmail() +"','" + user.getPassword() + "'," + user.getDateCreated() + ",'"
					+ user.getDateUpdated() + "')";
			userId = this.database.executeUpdate(sql);
			if (userId != 0) {
				user.setUserId(userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return userId;
	}

	public int updateUser(User user) {
		int result = 0;
		try {
			String sql = "UPDATE users SET fullname = '" + user.getName() + "'," + "gender = '" + user.getGender()
					+ "'," + "state = '" + user.getState() + "'," + "city = '" + user.getCity() + "'," + "street = '"
					+ user.getStreet() + "'," + "zipcode = " + user.getZip() + "," + "birthyear = '"
					+ user.getBirthYear() + "email = '" + user.getEmail() + "'," + "password = '" + user.getPassword()
					+ "'," + "datecreated = '" + user.getDateCreated() + "'," + "dateupdated = '"
					+ user.getDateUpdated() + "' WHERE idGuest = " + user.getUserId();
			result = this.database.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return result;
	}

	public int deleteUserById(int userId) {
		int result = 0;
		try {
			String sql = "DELETE FROM users WHERE userid = '" + userId + "'";
			result = this.database.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return result;
	}

	public User getUserById(int userId) {
		User user = null;
		try {
			String sql = "SELECT * FROM users WHERE userid = '" + userId + "' LIMIT 1";
			ResultSet rs = this.database.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setGender(rs.getInt(3));
				user.setState(rs.getString(4));
				user.setCity(rs.getString(5));
				user.setStreet(rs.getString(6));
				user.setZip(rs.getInt(7));
				user.setBirthYear(rs.getInt(8));
				user.setEmail(rs.getString(9));
				user.setPassword(rs.getString(10));
				user.setDateCreated(rs.getDate(11));
				user.setDateCreated(rs.getDate(12));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return user;
	}

	public User getUserByEmail(String email) {
		User user = null;
		try {
			String sql = "SELECT * FROM users WHERE email = '" + email + "' LIMIT 1";
			ResultSet rs = this.database.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setGender(rs.getInt(3));
				user.setState(rs.getString(4));
				user.setCity(rs.getString(5));
				user.setStreet(rs.getString(6));
				user.setZip(rs.getInt(7));
				user.setBirthYear(rs.getInt(8));
				user.setEmail(rs.getString(9));
				user.setPassword(rs.getString(10));
				user.setDateCreated(rs.getDate(11));
				user.setDateCreated(rs.getDate(12));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return user;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		User user = null;
		try {
			String sql = "SELECT * FROM users";
			ResultSet rs = this.database.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setGender(rs.getInt(3));
				user.setState(rs.getString(4));
				user.setCity(rs.getString(5));
				user.setStreet(rs.getString(6));
				user.setZip(rs.getInt(7));
				user.setBirthYear(rs.getInt(8));
				user.setEmail(rs.getString(9));
				user.setPassword(rs.getString(10));
				user.setDateCreated(rs.getDate(11));
				user.setDateCreated(rs.getDate(12));
				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return users;
	}

}
