import jieba
from wordcloud import WordCloud
# 1.读取小说内容
with open('./novel/novel/threekingdom.txt', 'r', encoding='utf-8') as f:
    words = f.read()

    counts = {}  # {‘曹操’:234，‘回寨’:56}
    excludes = {"将军", "却说", "丞相", "二人", "不可", "荆州", "不能", "如此", "商议",
                "如何", "主公", "军士", "军马", "左右", "次日", "引兵", "大喜", "天下",
                "东吴", "于是", "今日", "不敢", "魏兵", "陛下", "都督", "人马", "不知",
                "孔明曰","玄德曰","刘备","云长"}
    # 2. 分词
    words_list = jieba.lcut(words)
    # print(words_list)
    for word in words_list:
        # 更新字典中的值
        # counts[word] = 取出字典中原来键对应的值 + 1
        # counts[word] = counts[word] + 1  # counts[word]如果没有就要报错
        # 字典。get（k） 如果字典中没有这个键 返回 NONE
        counts[word] = counts.get(word, 0) + 1

    print(len(counts))
    # 3. 词语过滤,删除无关词，重复词
    counts['孔明'] =  counts['孔明'] +  counts['孔明曰']
    counts['玄德'] = counts['玄德'] + counts['玄德曰'] +counts['刘备']
    counts['关公'] = counts['关公'] +counts['云长']
    for word in excludes:
        del counts[word]

    # 4.排序 [(), ()]
    items = list(counts.items())
    print(items)

    # def sort_by_count(x):
    #     return x[1]
    items.sort(key=lambda x:x[1], reverse=True)

    li = []  # ['孔明'， 孔明， 孔明，孔明...., '曹操'。。。。。]
    lo = []
    for i in range(10):
        # 序列解包
        role, count = items[i]
        print(role, count)
        li.append(role)
        lo.append(count)
        # _ 是告诉看代码的人，循环里面不需要使用临时变量
        # for _ in range(count):
        #     li.append(role)
    # 5得出结论

    text = ' '.join(li)
    print(li)
    WordCloud(
        font_path='msyh.ttc',
        background_color='white',
        width=800,
        height=600,
        # 相邻两个重复词之间的匹配
        collocations=False
    ).generate(text).to_file('TOP10.png')

# 饼图
from matplotlib import pyplot as plt
plt.rcParams["font.sans-serif"] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False
import numpy as np
from random import randint
import string
from random import randint
import string
# counts = [randint(3500, 9000) for _ in range(6)]
labels = ['孔明','玄德','曹操','关公','张飞','孙权','吕布','赵云','司马懿','周瑜']
# 距离圆心点距离
explode = [0.1,0,0, 0, 0,0,0,0, 0, 0]
# colors = ['red', 'purple','blue', 'yellow','gray','green','bl']
plt.pie(lo,shadow=True,explode=explode, labels=li, autopct = '%1.1f%%')
plt.legend(loc=2)
plt.axis('equal')
plt.show()
