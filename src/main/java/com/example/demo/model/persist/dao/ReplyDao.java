package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.MyThreadPk;
import com.example.demo.model.entities.Reply;

public interface ReplyDao {

	public Reply createReply(Reply reply);
	
	//public Reply updateReply(Reply reply);
	
	public void deleteReply(Reply reply);
	
	public List<Reply> readRepliesByUserId(long userId);
	
	public List<Reply> readRepliesByReplyPk(MyThreadPk threadPk);
	
}
