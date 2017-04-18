package com.niit.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.TextFileDAO;
import com.niit.model.TextFile;

@EnableTransactionManagement
@Repository("textFileDAO")
public class TextFileDAOImpl implements TextFileDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public TextFileDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public void save(TextFile textFile) {
		sessionFactory.getCurrentSession().save(textFile);
	}

}
