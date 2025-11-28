package com.project.spring.mydiary.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.spring.mydiary.entities.Entry;
import com.project.spring.mydiary.dao.EntryDaoInterface;

@Component
public class EntryBusinessInterfaceImpl implements EntryBusinessInterface {
	
	@Autowired
	private EntryDaoInterface entryDaoInterface;

	public EntryDaoInterface getEntryDaoInterface() {
		return entryDaoInterface;
	}

	public void setEntryDaoInterface(EntryDaoInterface entryDaoInterface) {
		this.entryDaoInterface = entryDaoInterface;
	}

	@Override
	public void save(Entry entry) {
		entryDaoInterface.save(entry);

	}

	@Override
	public void update(Entry entry) {
		entryDaoInterface.update(entry);

	}

	@Override
	public void delete(Entry entry) {
		entryDaoInterface.delete(entry);

	}

	@Override
	public Entry findById(int id) {
		return entryDaoInterface.findById(id);
	}

	@Override
	public List<Entry> findAll() {
		return entryDaoInterface.findAll();
	}

	@Override
	public List<Entry> findByUserId(int id) {
		return entryDaoInterface.findByUserId(id);
	}

}
