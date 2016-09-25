package com.tgb.manager;

import java.util.List;

import com.tgb.entity.OriFile;

public interface OriFileManager {
	
    public OriFile getOriFile(String id);
	
	public List<OriFile> getAllOriFile();
	
	public void addOriFile(OriFile file);
	
	public boolean delOriFile(String id);
	
	public boolean updateOriFile(OriFile file);

	public List<OriFile> searchAllOriFile(String content);

}
