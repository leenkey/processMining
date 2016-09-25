package com.tgb.dao;

import java.util.List;

import com.tgb.entity.OriFile;

public interface OriFileDao {
	
	public OriFile getOriFile(String id);
	
	public List<OriFile> getAllOriFile();
	
	public void addOriFile(OriFile orifile);
	
	public boolean delOriFile(String id);
	
	public boolean updateOriFile(OriFile orifile);

	public List<OriFile> searchAllOriFile(String content);

}
