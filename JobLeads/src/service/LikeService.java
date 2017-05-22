package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbconnection.Database;
import dbconnection.IDatabase;
import model.Like;

public class LikeService {
	private IDatabase database = Database.getInstance();

	public int saveLike(Like like) {
		int likeId = 0;
		try {
			String sql = "INSERT INTO likes (likeid, userid, postid, datecreated, datecreated " + ") VALUES ('"
					+ like.getLikeId() + "','" + like.getUserId() + "','" + like.getPostId() + "','" + "','"
					+ like.getDateCreated() + "'," + like.getDateUpdated() + "')";
			likeId = this.database.executeUpdate(sql);
			if (likeId != 0) {
				like.setLikeId(likeId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return likeId;
	}

	public int deleteLikeById(int likeId) {
		int result = 0;
		try {
			String sql = "DELETE FROM comments WHERE likeid = '" + likeId + "'";
			result = this.database.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return result;
	}

	public int deleteLikeByUserIdAndPostID(int userId, int postId) {
		int result = 0;
		try {
			String sql = "DELETE FROM likes WHERE userid = '" + userId + "'" + "and" + "postid = '" + postId + "'";
			result = this.database.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return result;
	}

	public Like getLikeById(int likeId) {
		Like lik = null;
		try {
			String sql = "SELECT * FROM likes WHERE likeid = '" + likeId + "' LIMIT 1";
			ResultSet rs = this.database.executeQuery(sql);
			if (rs.next()) {
				lik = new Like();
				lik.setLikeId(rs.getInt(1));
				lik.setUserId(rs.getInt(2));
				lik.setPostId(rs.getInt(3));
				lik.setDateCreated(rs.getDate(4));
				lik.setDateUpdated(rs.getDate(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return lik;
	}

	public Like getLikeByUserIdAndPostId(int userId, int postId) {
	
		Like lik = null;
		try {
			String sql = "SELECT * FROM likes WHERE userid = '" + userId+ "and" + "postid = '" + postId + "'" + "' LIMIT 1";
			ResultSet rs = this.database.executeQuery(sql);
			if (rs.next()) {
				lik = new Like();
				lik.setLikeId(rs.getInt(1));
				lik.setUserId(rs.getInt(2));
				lik.setPostId(rs.getInt(3));
				lik.setDateCreated(rs.getDate(4));
				lik.setDateUpdated(rs.getDate(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return lik;
	}

	public List<Like> getAllLikes() {
		List<Like> likes = new ArrayList<>();
		Like lik = null;
		try {
			String sql = "SELECT * FROM likes";
			ResultSet rs = this.database.executeQuery(sql);
			while (rs.next()) {
				lik = new Like();
				lik.setLikeId(rs.getInt(1));
				lik.setUserId(rs.getInt(2));
				lik.setPostId(rs.getInt(3));
				lik.setDateCreated(rs.getDate(4));
				lik.setDateUpdated(rs.getDate(5));
				likes.add(lik);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return likes;
	}
}
