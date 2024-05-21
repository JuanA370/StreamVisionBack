package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.entities.MyThreadPk;
import com.example.demo.model.entities.Reply;
import com.example.demo.model.persist.dao.ReplyDao;
import com.example.demo.model.persist.repository.ReplyRepository;

@Service
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private ReplyRepository replyRep;
	
	@Override
	public Reply createReply(Reply reply) {
		return replyRep.save(reply);
	}
	
	public void deleteReply(Reply reply) {
		replyRep.delete(reply);
	}

	public List<Reply> readRepliesByUserId(long userId) {
		return replyRep.findRepliesByUserId(userId);
	}

	public List<Reply> readRepliesByReplyPk(MyThreadPk threadPk) {
		List<Reply> replies = replyRep.findRepliesByThreadPk(threadPk);
		if (replies.isEmpty())
			throw new AppException("There are no replies matching your search", HttpStatus.NOT_FOUND);
		return replies;
	}
}
