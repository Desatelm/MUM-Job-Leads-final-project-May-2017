package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbconnection.Database;
import dbconnection.IDatabase;
import model.Comment;

public class CommentService {
	private IDatabase database = Database.getInstance();

	public int saveComment(Comment comm) {
		int commentId = 0;
		try {
			String sql = "INSERT INTO comments (commentid, userid, postid, comment,  datecreated, datecreated " + ") VALUES ('"
					+ comm.getCommentId() + "','" + comm.getUserId()+ "','" + comm.getPostId() + "','" + comm.getComment()
					+ "','" + comm.getDateCreated() + "'," + comm.getDateUpdated() + "')";
			commentId = this.database.executeUpdate(sql);
			if (commentId != 0) {
				comm.setCommentId(commentId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return commentId;
	}

	public int deleteCommentById(int comId) {
		int result = 0;
		try {
			String sql = "DELETE FROM comments WHERE commentid = '" + comId + "'";
			result = this.database.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return result;
	}

	public int deleteCommentByUserId(int userId) {
		int result = 0;
		try {
			String sql = "DELETE FROM comments WHERE userid = '" + userId + "'";
			result = this.database.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return result;
	}

	public Comment getCommentById(int comId) {
		Comment comm = null;
		try {
			String sql = "SELECT * FROM comments WHERE commentid = '" + comId + "' LIMIT 1";
			ResultSet rs = this.database.executeQuery(sql);
			if (rs.next()) {
				comm = new Comment();
				comm.setCommentId(rs.getInt(1));
				comm.setUserId(rs.getInt(2));
				comm.setPostId(rs.getInt(3));				
				comm.setComment(rs.getString(4));
				comm.setDateCreated(rs.getDate(5));
				comm.setDateUpdated(rs.getDate(6));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return comm;
	}

	public List<Comment> getCommentsByUserId(int userId) {
		List<Comment> comms = new ArrayList<>();
		Comment comm = null;
		try {
			String sql = "SELECT * FROM comments WHERE userid = '" + userId + "' LIMIT 1";
			ResultSet rs = this.database.executeQuery(sql);
			while (rs.next()) {
				comm = new Comment();
				comm.setCommentId(rs.getInt(1));
				comm.setUserId(rs.getInt(2));
				comm.setPostId(rs.getInt(3));				
				comm.setComment(rs.getString(4));
				comm.setDateCreated(rs.getDate(5));
				comm.setDateUpdated(rs.getDate(6));
				comms.add(comm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return comms;
	}

	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<>();
		Comment comm = null;
		try {
			String sql = "SELECT * FROM comments";
			ResultSet rs = this.database.executeQuery(sql);
			while (rs.next()) {
				comm = new Comment();
				comm.setCommentId(rs.getInt(1));
				comm.setUserId(rs.getInt(2));
				comm.setPostId(rs.getInt(3));				
				comm.setComment(rs.getString(4));
				comm.setDateCreated(rs.getDate(5));
				comm.setDateUpdated(rs.getDate(6));
				comments.add(comm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return comments;
	}
}
