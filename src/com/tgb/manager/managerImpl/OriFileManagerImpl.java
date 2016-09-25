package com.tgb.manager.managerImpl;

import java.util.List;

import com.tgb.dao.OriFileDao;
import com.tgb.entity.OriFile;
import com.tgb.manager.OriFileManager;

public class OriFileManagerImpl implements OriFileManager {

	private OriFileDao oriFileDao;

	public OriFileDao getOriFileDao() {
		return oriFileDao;
	}

	public void setOriFileDao(OriFileDao oriFileDao) {
		this.oriFileDao = oriFileDao;
	}

	@Override
	public OriFile getOriFile(String id) {
		return oriFileDao.getOriFile(id);
	}

	@Override
	public List<OriFile> getAllOriFile() {
		return oriFileDao.getAllOriFile();
	}

	@Override
	public void addOriFile(OriFile file) {
		oriFileDao.addOriFile(file);
	}

	@Override
	public boolean delOriFile(String id) {
		return oriFileDao.delOriFile(id);
	}

	@Override
	public boolean updateOriFile(OriFile file) {
		return oriFileDao.updateOriFile(file);
	}
	@Override
	public List<OriFile> searchAllOriFile(String content){
		return oriFileDao.searchAllOriFile(content);
	}

}
