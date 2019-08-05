# -*- coding: utf-8 -*-
# @Time    : 2019/7/29 10:15
# @Author  : Eric Lee
# @Email   : li.yan_li@neusoft.com
# @File    : demo4.py
# @Software: PyCharm
# python常用数据类型
# 列表: 与c语言中的数组很相似， 只不过可以存储不同类型的数据
# 优点：灵活   ，缺点： 效率低
# 定义方式  []
# hero_name = ['鲁班七号', '安琪拉', '李白', '刘备']
# # 输出
# # print(hero_name)
# # 遍历
# # for hero in hero_name:
# #     print(hero)
#
# # 常见操作
# # 1.列表的访问
# # 列表名[索引]
# print(hero_name[2])
#
# # 2.添加 append
# hero_name.append('后羿')
# print('添加后的列表', hero_name)
#
# # 3.修改
# hero_name[1] = 1000
# print('修改后的列表',hero_name)
#
# # 4.删除
# del hero_name[1]
# print('删除后的列表',hero_name)
#
# # 练习
# # 创建 [1, 2, 3......10] 这样的一个数字列表
# # 1.创建空列表
# li = []
# # 2.使用for 循环， 在循环中添加元素值
# for i in range(1, 11):
#     li.append(i)
# print(li)

# 字符串
# 定义形式   ''  ""
# 切片 对序列截取一部分的操作，适用于列表
# name = 'abcdefg'
# # name[1]
# # [起始位置:终止位置：步长] 左闭右开
# print(name[1:4])
# # a c e g
# print(name[0:7:2])
# # 全切片的时候可以省略初始和终止位置
# print(name[::2])
# 常用方法
# 去两端空格

# name = '    abcdefg     '
# # 查看序列内元素的个数  len（）
# print(len(name))
# name = name.strip()
# print('去空格之后', len(name))

#  替换
# price = '$999'
# price = price.replace('$','')
# print(price)
# # 列表变成字符串的方法 join
# li = ['a', 'b', 'c', 'd']
# a = '_'.join(li)
# print(a)
# print(type(a))
# 数字
# 元组 tuple  元组和列表很像只不过元组不可以修改
# 定义  ()
# a = ('zhangsan', 'lisi', 'wangwu',1000)
# print(a)
# print(type(a))
#
# # 访问
# print(a[1])
# # # 修改
# # a[3] = 'zhaoliu'
#
# # 关于元组需要注意的是 只有一个元素的元组
# b = ('lisi',) #是不是元组
# c = (1000,) #是不是元组
# print(type(b))
# print(type(c))


# 字典  dict   java  hashmap
# key-value数据结构
# 定义形式  {}
info = {'name':'李四', 'age':34, 'addr':'重庆市渝北区'}
print(len(info))
print(info)
# 1.字典的访问
print(info['name'])
# 2.修改
info['addr'] = '北京市朝阳区'
print('修改后字典',info)

# 3.增加
info['sex'] = 'female'
print('增加后字典',info)

# 获取字典中所有的键
print(info.keys())

#  # 获取字典中所有的z值
print(info.values())

# 获取字典中所有的key-value
print(info.items())

d = [('name', '李四'), ('age', 34), ('addr', '北京市朝阳区'), ('sex', 'female')]
d1 = dict(d)
print(d1)
#  遍历字典
for k, v in info.items():
    print(k, v)

# 集合
#  无序，不重复
set1 = {'zhangsan', 'lisi', 222}
#
print(type(set1))
# 遍历
for x in set1:
    print(x)





