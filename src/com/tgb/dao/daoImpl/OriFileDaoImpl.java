package com.tgb.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tgb.dao.OriFileDao;
import com.tgb.entity.OriFile;

public class OriFileDaoImpl implements OriFileDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public OriFile getOriFile(String id) {
		String hql = "from OriFile f where f.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (OriFile)query.uniqueResult();
	}

	@Override
	public List<OriFile> getAllOriFile() {
		String hql = "from OriFile";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Override
	public List<OriFile> searchAllOriFile(String content){
		String hql = "from OriFile f where f.orifileName like '%content%'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void addOriFile(OriFile orifile) {
		sessionFactory.getCurrentSession().save(orifile);
	}

	@Override
	public boolean delOriFile(String id) {
		String hql = "delete OriFile f where f.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
//		System.out.println(hql + id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateOriFile(OriFile orifile) {
		String hql = "update OriFile of set of.orifileName = ?,of.format=?,of.eventLog=?,of.creationDate?,of.creationBy=?,of.orifilePath=? where of.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, orifile.getOrifileName());
		query.setString(1, orifile.getFormat());
		query.setString(2, orifile.getEventLog());
		query.setString(3, orifile.getCreationDate());
		query.setString(4, orifile.getCreationBy());
		query.setString(5, orifile.getId());
		query.setString(6, orifile.getOrifilePath());
		
		return (query.executeUpdate() > 0);
	}

}
