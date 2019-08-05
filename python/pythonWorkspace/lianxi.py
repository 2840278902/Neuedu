import jieba
from wordcloud import WordCloud
with open('./novel/novel/threekingdom.txt' ,'r',encoding='utf-8') as f:
    words = f.read()

    counts = {}

    excludes = {"将军", "却说", "丞相", "二人", "不可", "荆州", "不能", "如此", "商议",
                "如何", "主公", "军士", "军马", "左右", "次日", "引兵", "大喜", "天下",
                "东吴", "于是", "今日", "不敢", "魏兵", "陛下", "都督", "人马", "不知",
                "孔明曰", "玄德曰", "刘备", "云长"}
    words_list = jieba.lcut(words)


    for word in words_list:
        if len(word) <= 1:
            continue
        else:
            counts[word] = counts.get(word,0) + 1 # 没有的话默认为0

    counts['孔明'] = counts['孔明'] + counts['孔明曰']
    counts['玄德'] = counts['玄德'] + counts['玄德曰'] + counts['刘备']
    counts['关公'] = counts['关公'] + counts['云长']

    for word in excludes:
        del counts[word]
    item = list(counts.items())
    print(counts)
    print(item)


    def sort_by_counts(x):
        return x[1]
    item.sort(key=sort_by_counts,reverse=True)

    li = []
    for i in range(10):
        role,count = item[i]
        # print(role,count)
        for _ in range(count):
            li.append(role)
    text = ' '.join(li)
    # print(text)
    WordCloud(
        font_path='msyh.ttc',
        background_color='white',
        width=800,
        height=600,
        # 相邻两个重复词之间的匹配
        collocations=False
    ).generate(text).to_file('TOP10.png')

