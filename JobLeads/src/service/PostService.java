package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbconnection.Database;
import dbconnection.IDatabase;
import model.Post;

public class PostService {
	private IDatabase database = Database.getInstance();

	public int savePost(Post post) {
		int postId = 0;
		try {
			String sql = "INSERT INTO posts (postid, userid, post, posttype,  datecreated, datecreated " + ") VALUES ('"
					+ post.getPostId() + "','" + post.getUserId() + "','" + post.getPost() + "','" + post.getPostType()
					+ "','" + post.getDateCreated() + "'," + post.getDateUpdated() + "')";
			postId = this.database.executeUpdate(sql);
			if (postId != 0) {
				post.setUserId(postId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return postId;
	}

	public int deletePostById(int postId) {
		int result = 0;
		try {
			String sql = "DELETE FROM posts WHERE postid = '" + postId + "'";
			result = this.database.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return result;
	}

	public int deletePostByUserId(int userId) {
		int result = 0;
		try {
			String sql = "DELETE FROM posts WHERE userid = '" + userId + "'";
			result = this.database.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return result;
	}

	public Post getPostById(int postId) {
		Post post = null;
		try {
			String sql = "SELECT * FROM posts WHERE postid = '" + postId + "' LIMIT 1";
			ResultSet rs = this.database.executeQuery(sql);
			if (rs.next()) {
				post = new Post();
				post.setPostId(rs.getInt(1));
				post.setUserId(rs.getInt(2));
				post.setPost(rs.getString(3));
				post.setPostType(rs.getInt(4));
				post.setDateCreated(rs.getDate(5));
				post.setDateUpdated(rs.getDate(6));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return post;
	}

	public List<Post> getPostByUserId(int userId) {
		List<Post> posts = new ArrayList<>();
		Post post = null;
		try {
			String sql = "SELECT * FROM posts WHERE userid = '" + userId + "' LIMIT 1";
			ResultSet rs = this.database.executeQuery(sql);
			while (rs.next()) {
				post = new Post();
				post.setPostId(rs.getInt(1));
				post.setUserId(rs.getInt(2));
				post.setPost(rs.getString(3));
				post.setPostType(rs.getInt(4));
				post.setDateCreated(rs.getDate(5));
				post.setDateUpdated(rs.getDate(6));
				posts.add(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return posts;
	}

	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		Post post = null;
		try {
			String sql = "SELECT * FROM posts";
			ResultSet rs = this.database.executeQuery(sql);
			while (rs.next()) {
				post = new Post();
				post.setPostId(rs.getInt(1));
				post.setUserId(rs.getInt(2));
				post.setPost(rs.getString(3));
				post.setPostType(rs.getInt(4));
				post.setDateCreated(rs.getDate(5));
				post.setDateCreated(rs.getDate(6));
				posts.add(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
		return posts;
	}

}
