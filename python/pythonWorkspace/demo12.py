# -*- coding: utf-8 -*-
# @Time    : 2019/7/30 14:03
# @Author  : Eric Lee
# @Email   : li.yan_li@neusoft.com
# @File    : demo12.py
# @Software: PyCharm

#  matplotlib
#  导入
from matplotlib import pyplot as plt
plt.rcParams["font.sans-serif"] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False
import numpy as np

#  使用100个点 绘制 [0 , 2π]正弦曲线图
#.linspace 左闭右闭区间的等差数列
# x = np.linspace(0, 2*np.pi, num=100)
# print(x)
# y = np.sin(x)
# #  正弦和余弦在同一坐标系下
# cosy = np.cos(x)
# plt.plot(x, y, color='g', linestyle='--',label='sin(x)')
# plt.plot(x, cosy, color='r',label='cos(x)')
# plt.xlabel('时间（s）')
# plt.ylabel('电压（V）')
# plt.title('欢迎来到python世界')
# # 图例
# plt.legend()
# plt.show()

# 柱状图
# import string
# from random import randint
# # print(string.ascii_uppercase[0:6])
# # ['A', 'B', 'C'...]
# x = ['口红{}'.format(x) for x in string.ascii_uppercase[:5] ]
# y = [randint(200, 500) for _ in range(5)]
# print(x)
# print(y)
# plt.xlabel('口红品牌')
# plt.ylabel('价格（元）')
# plt.bar(x, y)
# plt.show()


#饼图
# from random import randint
# import string
# counts = [randint(3500, 9000) for _ in range(6)]
# labels = ['员工{}'.format(x) for x in string.ascii_lowercase[:6] ]
# # 距离圆心点距离
# explode = [0.1,0,0, 0, 0,0]
# colors = ['red', 'purple','blue', 'yellow','gray','green']
# plt.pie(counts,explode = explode,shadow=True, labels=labels, autopct = '%1.1f%%',colors=colors)
# plt.legend(loc=2)
# plt.axis('equal')
# plt.show()


x = np.random.normal(0, 1, 100)
y = np.random.normal(0, 1, 100)
plt.scatter(x, y)
plt.show()
#
# 散点图
# 均值为 0 标准差为1 的正太分布数据
x = np.random.normal(0, 1, 1000000)
y = np.random.normal(0, 1, 1000000)
# alpha透明度
plt.scatter(x, y, alpha=0.1)
plt.show()

# 绘制 三国top10 饼图
# 红楼梦 top1o人物分析

















