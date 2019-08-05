# -*- coding: utf-8 -*-
# @Time    : 2019/7/29 15:38
# @Author  : Eric Lee
# @Email   : li.yan_li@neusoft.com
# @File    : demo9.py
# @Software: PyCharm
import jieba
# 三国演义小说分词
# 读取三国演义小说
with open('./novel/threekingdom.txt','r', encoding='utf-8') as f:
    words = f.read()
    print(len(words)) # 字数  55万
    words_list = jieba.lcut(words)
    print(len(words_list)) # 分词后的词语数  35万
    print(words_list)


# 分词



