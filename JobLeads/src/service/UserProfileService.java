package service;

import dbconnection.Database;
import dbconnection.IDatabase;
import model.User;

public class UserProfileService {
	private IDatabase database = Database.getInstance();

	public int saveUser(User user) {
		int userId = 0;

		return userId;
	}

}
