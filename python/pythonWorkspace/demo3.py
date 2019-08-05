# -*- coding: utf-8 -*-
# @Time    : 2019/7/29 9:12
# @Author  : Eric Lee
# @Email   : li.yan_li@neusoft.com
# @File    : demo3.py
# @Software: PyCharm

# Python标准库中的GUI界面  -- 》  turtle
# turtle的简单使用
# 导入turtle  as 是给起一个别名
import turtle as t
# 设置画笔的大小  10px
t.pensize(10)
t.color('blue')
# 绘制 NEUSOFT
# 水平左移
# 抬笔
t.penup()
t.goto(-260, 0)
t.pd()

# 绘制 N
t.left(90)
t.forward(80)
t.right(145)
# 简写
t.fd(100)
t.lt(145)
t.fd(80)

# 绘制 S
t.penup()
t.goto(120, 50)
t.pd()

t.circle(22,270)
# r 是正数值时，以左手边为圆心画弧，负值是以右手边为圆心画弧
# angle 是负数时候 代表绘制方向
t.circle(-22,270)





# 绘制 O
# t.penup()
# t.goto(200, 40)
# t.pd()
#
# t.circle(30)


# 让gui界面一直显示, 所有执行的代码要写在此函数之前
t.done()