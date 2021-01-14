## 给表添加字段
ALTER TABLE 表名 ADD COLUMN 字段名 字段类型 (默认值) (COMMENT '注释') 
    例如:
   
    ALTER TABLE device ADD COLUMN `device_ip` VARCHAR(32) DEFAULT NULL COMMENT '设备IP';