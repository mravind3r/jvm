package com.spring.training.policytest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/*
 * jdk provides a special tool called policytool to create a policfile
 * >policytool 
 * opens a UI , u can create a policy file and save it under a directory 
 * 
 * the jvm argument is  -Djava.security.policy=/Users/ravi/repositories/spring-training/policyfile
 */

public class PolicyTest {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
        try {
            FileOutputStream fout=new FileOutputStream("/Users/ravi/repositories/spring-training/a.txt");
            fout.write("hello".getBytes());
            fout.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }


}
