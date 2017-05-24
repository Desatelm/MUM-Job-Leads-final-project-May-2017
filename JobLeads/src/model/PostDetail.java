package model;

import java.util.Date;
import java.util.List;

public class PostDetail {
	private int postId;
	private String noOfLIkes;
	private String noOfComments;
	private Date postDate;
	
	private String post;
	private String location;
	private List<Comment> comments;
	

	public PostDetail(int postId, String noOfLIkes, String noOfComments, Date postDate, String post, String loc,
			List<Comment> comments) {
		super();
		this.postId = postId;
		this.noOfLIkes = noOfLIkes;
		this.noOfComments = noOfComments;
		this.postDate = postDate;
		this.post = post;
		this.location = loc;
		this.comments = comments;
	}

}
