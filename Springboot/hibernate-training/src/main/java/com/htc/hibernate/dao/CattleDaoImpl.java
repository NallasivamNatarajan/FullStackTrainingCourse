package com.htc.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.htc.hibernate.entity.Cattle;
import com.htc.hibernate.helper.MySessionFactory;

public class CattleDaoImpl implements CattleDao{

	private SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	
	public boolean addCattle(Cattle cattle) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean status = false;
		try {
			session.save(cattle);
			transaction.commit();
			status = true;
		}catch(Exception excepion) {
			transaction.rollback();
		}finally {
			session.close();
		}
		return status;
	}

	public Cattle getCattle(int cattleId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Cattle cattle = new Cattle();
		try {
			session.get(Cattle.class, cattleId);
			transaction.commit();
		}catch(Exception excepion) {
			transaction.rollback();
		}finally {
			session.close();
		}
		return cattle;
	}

	public boolean deleteCattle(Cattle cattle) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean status = false;
		try {
			session.delete(cattle);
			transaction.commit();
			status = true;
		}catch(Exception excepion) {
			transaction.rollback();
		}finally {
			session.close();
		}
		return status;
	}

	public boolean updateCattle(Cattle cattle) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean status = false;
		try {
			session.update(cattle);
			transaction.commit();
			status = true;
		}catch(Exception excepion) {
			transaction.rollback();
		}finally {
			session.close();
		}
		return status;
	}

	public List<Cattle> getCattleList() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Cattle> cattleList = new ArrayList<Cattle>();
		try {
			TypedQuery<Cattle> cattleListFromQuerry =  session.createQuery("From Cattle", Cattle.class);
			cattleListFromQuerry.getResultList();
			transaction.commit();
		}catch(Exception excepion) {
			transaction.rollback();
		}finally {
			session.close();
		}
		return cattleList;
	}

}
