import requests
from lxml import html
import pandas as pd
from matplotlib import pyplot as plt
plt.rcParams["font.sans-serif"] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False

def spider_dangdang(isbn):
    movie_list = []
    # 目标站点地址
    url = 'https://movie.douban.com/cinema/later/chongqing/'
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
    ul_list = selector.xpath('//div[@id="showing-soon"]/div')
    print('您好，共有{}部电影'.format(len(ul_list)))

    # 遍历 ul_list
    for li in ul_list:
        #  电影名称
        title = li.xpath('//div[@id="showing-soon"]/div/div[@class="intro"]/h3/a/text()')
        # print(title)
        #  上映日期
        link = li.xpath('//div[@id="showing-soon"]/div/div[@class="intro"]/ul/li[1]/text()')
        # print(link)
        #  类型
        price = li.xpath('//div[@id="showing-soon"]/div/div[@class="intro"]/ul/li[2]/text()')

        #国家
        country = li.xpath('//div[@id="showing-soon"]/div/div[@class="intro"]/ul/li[3]/text()')
        coNum = country
        # 想看人数
        store = li.xpath('//div[@id="showing-soon"]/div/div[@class="intro"]/ul/li[@class="dt last"]/span/text()')
        want = []
        for i in store:
            # print(i)
            i = int(i.replace('人想看',''))
            want.append(i)

        # 添加每一个电影的信息
    for i in range(len(ul_list)):
        movie_list.append({
            'name':title[i],
            'type':price[i],
            'date':link[i],
            'want':want[i],
            'country':country[i]
        })

    print(movie_list)
    counts = {}
    lk = []
    ll =[]
    print(coNum)


    for word in coNum:
        counts[word] = counts.get(word, 0) + 1


    print(len(counts))
    count = list(counts.items())
    for i in range(len(counts)):
        countrys, cons = count[i]
        cons = int(cons)
        countrys = str(countrys)
        lk.append(countrys)
        ll.append(cons)
        print(countrys)
        print(cons)

    explode = [0.1, 0, 0, 0]
    # colors = ['red', 'purple','blue', 'yellow','gray','green','bl']
    plt.pie(ll, shadow=True, explode=explode, labels=lk, autopct='%1.1f%%')
    plt.legend(loc=2)
    plt.axis('equal')
    plt.show()


    # 按想看人数进行排序
    movie_list.sort(key=lambda x:x['want'] ,reverse=True)

    # # 遍历booklist
    # for movie in movie_list:
    #     print(movie)
    #
    # # 展示最想看的前5个电影 柱状图
    # 电影名称
    top5_movie = [movie_list[i] for i in range(5)]
    # x = []
    # for store in top10_store:
    #     x.append(store['store'])
    x = [x['name'] for x in top5_movie]
    # print(x)
    # 想看人数
    y = [x['want'] for x in top5_movie]
    # print(y)
    # for i in range(5):
    #     print(top5_movie[i])
    plt.barh(x, y)
    plt.show()

    # # 存储成csv文件

    df = pd.DataFrame(movie_list)
    df.to_csv('dangdang.csv')

spider_dangdang('9787115428028')