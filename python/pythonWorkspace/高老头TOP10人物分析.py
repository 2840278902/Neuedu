import jieba
from wordcloud import WordCloud
# 1.读取小说内容
with open('./novel/novel/all.txt', 'r', encoding='utf-8') as f:
    words = f.read()

    counts = {}  # {‘曹操’:234，‘回寨’:56}
    # excludes = {"什么", "一个", "我们", "你们", "如今", "说道", "知道", "老太太", "姑娘",
    #             "起来", "这里", "出来", "众人", "那里", "奶奶", "自己", "太太", "一面",
    #             "只见", "两个", "没有", "怎么", "不是", "不知", "这个", "听见", "这样",
    #             "进来","咱们","就是","东西","告诉","回来","只是","大家","老爷","只得",
    #             "丫头","这些","他们","不敢","出去","所以","贾母笑","凤姐儿","不过"}
    # 2. 分词
    words_list = jieba.lcut(words)
    # print(words_list)
    for word in words_list:
        if len(word) <= 1:
            continue
        else:
            # 更新字典中的值
            # counts[word] = 取出字典中原来键对应的值 + 1
            # counts[word] = counts[word] + 1  # counts[word]如果没有就要报错
            # 字典。get（k） 如果字典中没有这个键 返回 NONE
            counts[word] = counts.get(word, 0) + 1

    print(len(counts))
    # 3. 词语过滤,删除无关词，重复词
    # counts['贾母'] =  counts['贾母'] +  counts['贾母笑'] + counts['老太太']
    # counts['凤姐'] = counts['凤姐儿'] + counts['凤姐']
    # counts['王夫人'] = counts['王夫人'] + counts['太太']
    # counts['宝钗'] = counts['宝钗'] + counts['薛宝钗']
    # print('薛宝钗',counts['薛宝钗'])
    # counts['关公'] = counts['关公'] +counts['云长']
    for word in excludes:
        del counts[word]

    # 4.排序 [(), ()]
    items = list(counts.items())
    # print(items)

    def sort_by_count(x):
        return x[1]
    items.sort(key=lambda x:x[1], reverse=True)
    # print(items)

    # li = []  # ['孔明'， 孔明， 孔明，孔明...., '曹操'。。。。。]
    # lo = []
    # ll = []
    # for i in range(10):
    #     # 序列解包
    #     role, count = items[i]
    #     # print(role, count)
    #     li.append(role)
    #     lo.append(count)
    #     # print(li)
    #     # print(lo)
    #     # _ 是告诉看代码的人，循环里面不需要使用临时变量
    #     for _ in range(count):
    #         ll.append(role)

    # 5得出结论

    # text = ' '.join(ll)
    # WordCloud(
    #     font_path='msyh.ttc',
    #     background_color='white',
    #     width=800,
    #     height=600,
    #     # 相邻两个重复词之间的匹配
    #     collocations=False
    # ).generate(text).to_file('HTOP10.png')

# # 饼图
# from matplotlib import pyplot as plt
# plt.rcParams["font.sans-serif"] = ['SimHei']
# plt.rcParams['axes.unicode_minus'] = False
import numpy as np
from random import randint
import string
# from random import randint
# import string
# # counts = [randint(3500, 9000) for _ in range(6)]
# labels = ['孔明','玄德','曹操','关公','张飞','孙权','吕布','赵云','司马懿','周瑜']
# # 距离圆心点距离
# explode = [0.1,0,0, 0, 0,0,0,0, 0, 0]
# # # colors = ['red', 'purple','blue', 'yellow','gray','green','bl']
# plt.pie(lo,shadow=True,explode=explode, labels=li, autopct = '%1.11f%%')
# plt.legend(loc=2)
# plt.axis('equal')
# plt.show()
