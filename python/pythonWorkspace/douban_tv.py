# -*- coding: utf-8 -*-
# @Time    : 2019/8/2 9:18
# @Author  : Eric Lee
# @Email   : li.yan_li@neusoft.com
# @File    : douban_tv.py
# @Software: PyCharm
import requests
import json

headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"}

url = 'https://movie.douban.com/j/search_subjects?type=tv&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=0'

response = requests.get(url, headers=headers)
print(response.status_code)

#  获取响应  json 字符串
data = response.content.decode()
print(data)
print(type(data))
#
# # 把json 字符串转化成  python类型
# dict_data = json.loads(data)
# # print(type(dict_data))
# # print(dict_data)
#
# # 提取数据
# tv_list = dict_data['subjects']
# # print(tv_list)
#
# data_list = []
# # 遍历
# for tv in tv_list:
#     temp = {}
#     # 电视剧名
#     temp['title'] = tv['title']
#     # rate
#     temp['rate'] = tv['rate']
#     #  封面
#     temp['cover'] = tv['cover']
#     # url
#     temp['url'] = tv['url']
#     # [{},{},{}]
#     data_list.append(temp)
#
# for tv in  data_list:
#     print(tv)
#
# # 存储成json
#
# f = open('douban.json','w', encoding='utf-8')
# # 写入  ensure_ascii指定false
# json.dump(data_list, f, ensure_ascii=False)
#
#
#
