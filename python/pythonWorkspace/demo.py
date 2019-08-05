#
# age = input('请输入您的年龄')
# if int(age) >= 18:
#     print('大于等于18')
# i = 0
#
#
# score = 88
# if score >= 90 and score <= 100:
#     print('您的成绩等级为A')
# elif score >= 80 and score < 90:
#     print('您的成绩等级为B')
#
# i = 1
# sum_num = 0
# while i <= 100:
#     sum_num += i
#     i += 1
# print(sum_num)


# 猜数字游戏

# 1、准备知识
# from random import randint
# from 模块名 import name1, name2 ...
# randint(start,end) [start,end]
# print(randint(-20,20))

# while True:
#     print(randint(23,25))
# import random
#ramdom.randit

#字符串格式化输出
# hero_name = '鲁班七号'
# grade = 15
# print('您选择的英雄是{}当前等级为{}级'.format(hero_name,grade))

#2、游戏规则
# 控制台输入你要猜数字的范围
# 请您输入要猜数字的最大值
# 请您输入要猜数字的最小值


#　输入要猜的数字
# 程序告诉玩家大了还是小了，知道猜数字结束循环，i次竟然猜对了

# 统计猜数字的词素
# 1次才对，这是高手
# 2-5次才对，你也太厉害了吧，i次猜对
# 5次以上，你也太菜了吧，i次才猜对，洗洗睡吧


from random import randint

while True:


    min_num = int(input('请输入最小值'))
    max_num = int(input('请输入最大值'))
    if min_num >= max_num:
        print('大小不符合')
        continue
    ran = randint(min_num, max_num)
    i = 0
    while True:
        user = int(input('请输入你的猜测'))

        i += 1
        if user<ran:
            print('小了')
        elif user > ran:
            print('大了')
        elif user == ran:
            if i == 1:
                print('这是高手{}次猜对'.format(i))
            elif 2 < i and i < 5:
                print('你也太厉害了吧{}次猜对'.format(i))
            elif i > 5:
                print('你也太菜了{}次才猜对，洗洗睡吧'.format(i))
            break