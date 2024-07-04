package com.model;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateCriteria {
	@SuppressWarnings("unchecked")
	public static void main(String[]args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> proList = criteria.list();
		proList =session.createCriteria(Product.class).add(Restrictions.gt("price", 500)).list();
		for(Product pro:proList) {
			System.out.println(pro.getPname());
		}
		proList=session.createCriteria(Product.class).add(Restrictions.gt("qty",10)).list();
		for(Product pro:proList) {
			System.out.println(pro.getPname());
		}
		proList =criteria.setProjection(Projections.sum("price")).list();
		System.out.println("Sum of prices =" + proList.getFirst());
	
		proList = session.createCriteria(Product.class).addOrder(Order.desc("slno")).setMaxResults(1).list();
		for(Product emp4 : proList) { 
			System.out.println(emp4.getSlno());
		}
        proList =session.createCriteria(Product.class).addOrder(Order.desc("price")).setMaxResults(1).list();
		for(Product emp:proList) {
			System.out.println(emp.getPname());
		}
		proList =session.createCriteria(Product.class).addOrder(Order.asc("price")).setMaxResults(1).list();
		for(Product emp:proList) {
			System.out.println(emp.getPname());
		}

		
	}
}
		