# -*- coding: utf-8 -*-
# @Time    : 2019/7/31 11:28
# @Author  : Eric Lee
# @Email   : li.yan_li@neusoft.com
# @File    : spider_dangdang.py
# @Software: PyCharm
import requests
from lxml import html
import pandas as pd
from matplotlib import pyplot as plt
plt.rcParams["font.sans-serif"] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False
def spider_dangdang(isbn):
    book_list = []
    # 目标站点地址
    url = 'http://search.dangdang.com/?key={}&act=input'.format(isbn)
    # print(url)
    # 获取站点str类型的响应
    headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"}

    resp = requests.get(url, headers=headers)
    html_data = resp.text
    #  将html页面写入本地
    # with open('dangdang.html', 'w', encoding='utf-8') as f:
    #     f.write(html_data)

    # 提取目标站的信息
    selector = html.fromstring(html_data)
    ul_list = selector.xpath('//div[@id="search_nature_rg"]/ul/li')
    print('您好，共有{}家店铺售卖此图书'.format(len(ul_list)))

    # 遍历 ul_list
    for li in ul_list:
        #  图书名称
        title = li.xpath('./a/@title')[0].strip()
        # print(title)
        #  图书购买链接
        link = li.xpath('a/@href')[0]
        # print(link)
        #  图书价格
        price = li.xpath('./p[@class="price"]/span[@class="search_now_price"]/text()')[0]
        price = float(price.replace('¥',''))
        # print(price)
        # 图书卖家名称
        store = li.xpath('./p[@class="search_shangjia"]/a/text()')
        # if len(store) == 0:
        #     store = '当当自营'
        # else:
        #     store = store[0]
        store = '当当自营' if len(store) == 0 else store[0]
        # print(store)

        # 添加每一个商家的图书信息
        book_list.append({
            'title':title,
            'price':price,
            'link':link,
            'store':store
        })


    # 按照价格进行排序
    book_list.sort(key=lambda x:x['price'])

    # 遍历booklist
    for book in book_list:
        print(book)

    # 展示价格最低的前10家 柱状图
    # 店铺的名称
    top10_store = [book_list[i] for i in range(10)]
    # x = []
    # for store in top10_store:
    #     x.append(store['store'])
    x = [x['store'] for x in top10_store]
    print(x)
    # 图书的价格
    y = [x['price'] for x in top10_store]
    print(y)
    # plt.bar(x, y)
    plt.barh(x, y)
    plt.show()


    # 存储成csv文件


    df = pd.DataFrame(book_list)
    df.to_csv('dangdang.csv')










spider_dangdang('9787115428028')