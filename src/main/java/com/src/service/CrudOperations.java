package com.src.service;

/**
 * @author Sourav.Samanta
 *
 */
public interface CrudOperations {
	void create(String query);
	void insert(String query);
	void delete(String query);
	void selectvalues() throws ClassNotFoundException;
}
