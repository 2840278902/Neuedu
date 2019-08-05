# 导入
import requests
from lxml import etree
def spider_douban_top250():
    movie_list_info = []
    headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"}
    for i in range(0, 250, 25):
        url = 'https://movie.douban.com/top250?start={}&filter='.format(i)

        # 获取bytes类型响应
        data = requests.get(url, headers=headers).content
        html = etree.HTML(data)



        ol_list = html.xpath('//div[@id="content"]//div[@class="article"]/ol/li')

        for movie in ol_list:
            # 影片序号
            serial_number = movie.xpath('./div[@class="item"]/div[@class="pic"]/em/text()')
            if len(serial_number) == 0:
                serial_number = ''
            else:
                serial_number = serial_number[0]
            # print(serial_number)
            # 电影的名字
            movie_name = movie.xpath('./div[@class="item"]/div[@class="info"]/div[@class="hd"]/a/span[1]/text()')[0]
            # print(movie_name)
            # 电影的介绍
            movie_introduce = movie.xpath('./div[@class="item"]/div[@class="info"]/div[@class="bd"]/p[1]/text()')[0].strip()
            # print(movie_introduce)
            # 电影的星级
            star = movie.xpath('./div[@class="item"]/div[@class="info"]/div[@class="bd"]/div[@class="star"]/span[2]/text()')[0]
            # print(star)
            # 电影的评价
            evalute = movie.xpath(
                './div[@class="item"]/div[@class="info"]/div[@class="bd"]/div[@class="star"]/span[4]/text()')
            evalute = evalute[0].replace('人评价', '')
            # print(evalute)
            # 电影的描述
            describe = movie.xpath('./div[@class="item"]/div[@class="info"]/div[@class="bd"]/p[@class="quote"]/span[1]/text()')
            # print(describe)
            # 电影封面的地址
            movie_img_url = movie.xpath('./div[@class="item"]/div[@class="pic"]/a/img/@src')[0]
            # print(movie_img_url)

            movie_list_info.append({
                'serial_number': serial_number,
                'movie_name': movie_name,
                'movie_introduce': movie_introduce,
                'star': star,
                'evalute': evalute,
                'describe': describe,
                'movie_img_url': movie_img_url
            })
    for movie in movie_list_info:
        print(movie)

        # 下载图片
    for movie in movie_list_info:
        url = movie['movie_img_url']
        resp = requests.get(url)
        if resp.status_code == 200:
            img_name = '0000000{}.jpg'.format(movie['serial_number'])
            with open('./imgs/{}'.format(img_name), 'wb') as f:
                f.write(resp.content)


spider_douban_top250()