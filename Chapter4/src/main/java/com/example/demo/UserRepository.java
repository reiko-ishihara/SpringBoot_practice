package com.example.demo;

import com.example.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findById(int id);	// IDを1件取得する処理
	public void deleteById(int id);	// IDを1件削除する処理

}
