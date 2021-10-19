package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity		// Entityクラスとしてクラスを定義
@Table(name="user")		// Entityクラスに割り当てられるテーブル名
public class User {
	@Id		// プライマリキーを指定
	@GeneratedValue(strategy = GenerationType.AUTO)		// AUTO：プライマリキーを自動採番する
	@Column		// カラム名
	private int id;
	
	@Column
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
