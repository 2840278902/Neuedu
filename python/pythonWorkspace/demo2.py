# python 标准库中的GUI界面 -> turtle
#turtle的简单使用
# 导入turtle as 是给起一个别名
import turtle as t
# 设置笔画的大小 10px
t.pensize(10)
t.color('blue')
# 绘制 NEUSOFT
# 绘制 N
#水平左移、
# 抬笔
t.penup()
t.goto(-260,0)
t.pd()


t.left(90)
t.forward(80)
t.right(145)
# 简写
t.fd(100)
t.lt(145)
t.fd(80)

# 绘制 E
t.penup()
t.goto(-100,0)
t.pd()
t.lt(90)
t.fd(50)
t.right(90)
t.fd(80)
t.right(90)
t.fd(50)
t.pu()
t.goto(-150,40)
t.pd()
t.fd(50)

#绘制 U

t.pu()
t.goto(-50,80)
t.pd()
t.right(90)
t.fd(50)
t.circle(30,180)
t.fd(50)

# 绘制 E
t.pu()
t.goto(50,80)
t.pd()
t.rt(90)
t.fd(50)
t.pu()
t.goto(50,80)
t.pd()
t.rt(90)
t.fd(80)
t.lt(90)
t.fd(50)
t.pu()
t.goto(50,40)
t.pd()
t.fd(50)

# 绘制 D
t.pu()
t.goto(150,80)
t.pd()
t.rt(90)
t.fd(80)
t.lt(80)
t.circle(45,200)

# 绘制 U
t.pu()
t.goto(250,80)
t.pd()
t.rt(280)
t.fd(50)
t.circle(30,180)
t.fd(50)




#绘制 O
# t.penup()
# t.goto(100,30)
# t.pd()

# t.circle(30)

# 绘制 S
# t.penup()
# t.goto(120, 50)
# t.pd()

# t.circle(22,270)
#让GUI界面一直显示,所有执行的代码要写在此函数之前
t.done()