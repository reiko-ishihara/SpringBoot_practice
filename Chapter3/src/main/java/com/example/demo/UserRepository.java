package com.example.demo;

import com.example.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;


// データベース操作のために必要なリポジトリの作成
// JPAが提供するJpaRepositoryを継承するためだけのもの
public interface UserRepository extends JpaRepository<User, Long> {

}
