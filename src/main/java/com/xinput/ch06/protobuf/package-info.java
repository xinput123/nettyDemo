/**
 * protobuf对象
 * 1）java_package值得是该文件生成的java文件的包路径
 * 2）java_outer_classname值的是生成的class的名称
 * 3）message和enum是它的基本类型，很类似于java的class和枚举
 * 4）required表名这个字段是必须的，option表明这个字段可选，default表明这个字段有默认值
 * 5）repeat表明这个字段可以重复，类似于java中的List，该例子中Car的声明中，就相当于java中的List<Car>
 * 6）每个声明的后面的数字，例如1，2，3, 4等等，同级的声明不能重复
 */
package com.xinput.ch06.protobuf;