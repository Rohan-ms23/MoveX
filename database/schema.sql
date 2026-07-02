-- Active: 1760863247321@@localhost@3306@movex
use movex;
show tables;
select * from users;

package com.movex.movex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovexApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovexApplication.class, args);
	}

}
