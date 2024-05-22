package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.ReplyDto;
import com.example.demo.model.entities.MyThread;
import com.example.demo.model.entities.Reply;
import com.example.demo.model.persist.dao.ReplyDao;
import com.example.demo.model.persist.repository.MyThreadRepository;
import com.example.demo.model.persist.repository.ProductRepository;
import com.example.demo.model.persist.repository.ReplyRepository;

@Service
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private ReplyRepository replyRep;
	
	@Autowired
	private MyThreadRepository threadRep;
	
	@Autowired
	private ProductRepository productRep;
	
	@Override
	public Reply createReply(ReplyDto replyDto, Long logedUserId) {
		MyThread thread = threadRep.findById();
		return null;
	}
	
	public void deleteReplyById(Long replyId) {
		replyRep.deleteById(replyId);
	}

	public List<Reply> readRepliesByUserId(Long logedUserId) {
		return replyRep.findRepliesByUserId(logedUserId);
	}

	public List<Reply> readRepliesByReplyPk(MyThreadPk threadPk) {
		List<Reply> replies = replyRep.findRepliesByThreadPk(threadPk);
		if (replies.isEmpty())
			throw new AppException("There are no replies matching your search", HttpStatus.NOT_FOUND);
		return replies;
	}
}