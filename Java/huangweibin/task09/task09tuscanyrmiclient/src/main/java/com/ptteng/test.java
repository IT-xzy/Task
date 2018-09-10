package com.ptteng;



import com.ptteng.pojo.*;
import com.ptteng.service.CategoryService;

import java.rmi.Naming;

public class test {
	public static void main(String[] args) throws Exception {
		 CategoryService c  = (CategoryService) Naming.lookup("rmi://127.0.0.1:8998/TuscanyService");
		System.out.println(c.total());
		System.out.println("1");
		// System.out.println(c.list().toString());
		Page page = new Page();
		System.out.println(c.list(page));
		// System.out.println(c.list1("0","5").toString());

		// System.out.println(categoryService.total());
	}
}
