package interfaces;

import java.util.List;

public interface IRepository<T>{
	void create(T obj) throws Exception;
	void update(T obj) throws Exception;
	void delete(Integer id) throws Exception;
	
	List<T> findAll() throws Exception;
	T findById(Integer id) throws Exception;
}