package com.htc.spring.entity.relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.entity.relation.dao.FeedsRepository;
import com.htc.spring.entity.relation.entity.Feeds;

@Service("feedsService")
public class FeedsService {
	
	@Autowired
	FeedsRepository feedsRepository;

	public Feeds addFeed(Feeds feed) {
		return feedsRepository.save(feed);
	}

	public void deleteFeed(int feedId) {
		feedsRepository.deleteById(feedId);
	}

	public Feeds getFeedById(int feedId) {
		Optional<Feeds> feed = feedsRepository.findById(feedId);
		if (feed.isPresent())
			return feed.get();
		else
			return null;
	}

	public List<Feeds> getAllFeeds() {
		return (List<Feeds>) feedsRepository.findAll();
	}

	public int updateFeed(Feeds feeds) {
		Feeds feedModel = feedsRepository.save(feeds);
		return feedModel.getFeedId();
	}
}
