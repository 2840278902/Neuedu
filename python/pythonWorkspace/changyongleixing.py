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

num = []

for i in range(1,11):
    num.append(i)
print(num)


# 字符串
