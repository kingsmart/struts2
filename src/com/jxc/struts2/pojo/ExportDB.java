package com.jxc.struts2.pojo;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {
	public static void main(String[] args) {
		 Configuration config = new Configuration().configure();//AnnotationConfiguration
		 SchemaExport export = new SchemaExport(config);
		 export.create(true, true);
	}
}
