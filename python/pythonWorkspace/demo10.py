# -*- coding: utf-8 -*-
# @Time    : 2019/7/29 16:17
# @Author  : Eric Lee
# @Email   : li.yan_li@neusoft.com
# @File    : demo10.py
# @Software: PyCharm
# 词云展示
#  安装
# pip install wordcloud
# 本地安装python库
# 导入词云 WordCloud类
from wordcloud import WordCloud
import jieba
import imageio
# 绘制词云
# text = 'He was an old man who fished alone in a skiff in the Gulf Stream and he had gone eighty-four days now without taking a fish. In the first forty days a boy had been with him. But after forty days without a fish the boy’s parents had told him that the old man was now definitely and finally salao, which is the worst form of unlucky, and the boy had gone at their orders in another boat which caught three good fish the first week. It made the boy sad to see the old man come in each day with his skiff empty and he always went down to help him carry either the coiled lines or the gaff and harpoon and the sail that was furled around the mast. The sail was patched with flour sacks and, furled, it looked like the flag of permanent defeat.'
# wc = WordCloud().generate(text)
# wc.to_file('老人与海.png')

# 三国演义小说词云绘制

# 三国演义小说分词
# 读取三国演义小说
mask = imageio.imread('./china.jpg')
with open('./novel/novel/threekingdom.txt','r', encoding='utf-8') as f:
    words = f.read()
    # print(len(words)) # 字数  55万
    words_list = jieba.lcut(words)
    # print(len(words_list)) # 分词后的词语数  35万
    print(words_list)
    # 将words_list转化成字符串
    novel_words = " ".join(words_list)
    print(novel_words)
    # WordCloud()里面设置参数
    wc = WordCloud(
        font_path='msyh.ttc',
        background_color='white',
        width=800,
        height=600,
        mask=mask
    ).generate(novel_words)
    wc.to_file('三国词云.png')













