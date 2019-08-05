
# 1.掌握python常用数据类型和语法

# 列表的排序
# li = []
# for i in range(10):
#     li.append(i)
# print(li)
# from random import shuffle
# shuffle(li)
# print('随机打乱的列表', li)
# li.sort(reverse=True)
# print('排序后的列表', li)

stu_info = [
    {"name":'zhangsan', "age":18},
    {"name":'lisi', "age":30},
    {"name":'wangwu', "age":99},
    {"name":'tiaqi', "age":3},

]
print('排序前', stu_info)

# def 函数名(参数):
#     函数体
def sort_by_age(x):
    return x['age']

# key= 函数名    ---  按照什么进行排序
# 根据年龄大小进行正序排序
stu_info.sort(key=sort_by_age, reverse=True)
print('排序后', stu_info)

# 练习

name_info_list = [
    ('张三',4500),
    ('李四',9900),
    ('王五',2000),
    ('赵六',5500),
]

# 根据元组第二个元素进行正序排序

def sort_by_second(x):
    return x[1]

name_info_list.sort(key=sort_by_second,reverse=True)
print('按照第二个元素排序后',name_info_list)