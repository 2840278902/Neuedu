# 导入
import requests
import random
from bs4 import BeautifulSoup
# from lxml import etree
from lxml import html
from lxml import etree


# def get_ip_list(url, headers):
#     web_data = requests.get(url, headers=headers)
#     soup = BeautifulSoup(web_data.text, 'lxml')
#     ips = soup.find_all('tr')
#     ip_list = []
#     for i in range(1, len(ips)):
#         ip_info = ips[i]
#         tds = ip_info.find_all('td')
#         ip_list.append(tds[1].text + ':' + tds[2].text)
#     return ip_list
#
# def get_random_ip(ip_list):
#     proxy_list = []
#     for ip in ip_list:
#         proxy_list.append('http://' + ip)
#     proxy_ip = random.choice(proxy_list)
#     proxies = {'http': proxy_ip}
#     return proxies


def spider_douban_top250():


    img = 1
    movie_list_info = []
    headers = {"User-Agent": "Mozilla/5.0 (Windows NT 8.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"}
    for i in range(1, 200):
        proxy_info = {'host': 'web-proxy.oa.com', 'port': 8080}


        # Then we install this opener as the default opener for urllib2:
        url = 'https://www.ygdy8.net/html/gndy/dyzz/list_23_{}.html'.format(i)

        # 获取bytes类型响应
        data = requests.get(url, headers=headers,proxies=proxy_info)
        data.encoding = 'GBK'
        data = data.text
        selector = html.fromstring(data)
        # html = etree.HTML(data)



        ol_list = selector.xpath('//div[@class="co_content8"]/ul//table')
        print(len(ol_list))
        # print(ol_list)

        n = 0
        for movie in ol_list:
            # # 电影名称
            # name = movie.xpath('//a[@class="ulink"]/text()')[n]
            # 电影详细信息连接
            link = movie.xpath('//a[@class="ulink"]/@href')[n]
            link = 'https://www.ygdy8.net'+link
            # print(link)
            detail = requests.get(link,headers=headers,proxies=proxy_info).content
            depage = etree.HTML(detail)
            # 电影名称
            # name = depage.xpath('//p/text()')
            # if name == []:
            #     name = depage.xpath('//text()')[3]
            # else:
            #     name = name[5]
            # if name == ' ':
            name = depage.xpath('//text()')[3]

            print(img,name)
            # print(depage.xpath('//p/text()'))

            # 电影国家

            country = depage.xpath('//p/text()')
            if len(country) < 20:
                country = '无法获取'
            else:
                country = depage.xpath('//p/text()')[10].strip()[6:]

            print(country)

            # 电影年代
            year = depage.xpath('//p/text()')
            if len(year) < 20:
                year = '无法获取'
            else:
                year = depage.xpath('//p/text()')[9].strip()[6:]
                if len(year) > 4:
                    year = depage.xpath('//p/text()')[9].strip()[6:]
            print(year)

            # 类别
            type = depage.xpath('//p/text()')
            if len(type) < 20:
                type = '无法获取'
            else:
                type = depage.xpath('//p/text()')[11].strip()[6:]
            print(type)

            # 语言
            # languag = depage.xpath('//p/text()')[12].strip()[6:]
            # print(languag)

            # 字幕
            # word = depage.xpath('//p/text()')[13].strip()
            # print(word)
            #电影封面链接
            src = depage.xpath('//img/@src')
            # if len(src) < 20:
            #
            #     pass
            #     # print(src)
            # else:
            # if len(src) == 0:
            #     break
            # else:
            #     resp = requests.get(src)
            #     if resp.status_code == 200:
            #         with open('./ygdyIMG/{}.jpg'.format(img),'wb') as f:
            #             f.write(resp.content)
            #     else:
            #         pass





            # print(link)

            # print(name)

             # 影片序号
        #     serial_number = movie.xpath('./div[@class="item"]/div[@class="pic"]/em/text()')
        #     if len(serial_number) == 0:
        #         serial_number = ''
        #     else:
        #         serial_number = serial_number[0]
        #     # print(serial_number)
            # 电影的名字
            # print(movie)
            # movie_name = movie.xpath('//div[@class="co_content8"]/ul//table/tbody[1]/tr[1]')
            # print(movie_name)
        #     # 电影的介绍
        #     movie_introduce = movie.xpath('./div[@class="item"]/div[@class="info"]/div[@class="bd"]/p[1]/text()')[0].strip()
        #     # print(movie_introduce)
        #     # 电影的星级
        #     star = movie.xpath('./div[@class="item"]/div[@class="info"]/div[@class="bd"]/div[@class="star"]/span[2]/text()')[0]
        #     # print(star)
        #     # 电影的评价
        #     evalute = movie.xpath(
        #         './div[@class="item"]/div[@class="info"]/div[@class="bd"]/div[@class="star"]/span[4]/text()')
        #     evalute = evalute[0].replace('人评价', '')
        #     # print(evalute)
        #     # 电影的描述
        #     describe = movie.xpath('./div[@class="item"]/div[@class="info"]/div[@class="bd"]/p[@class="quote"]/span[1]/text()')
        #     # print(describe)
        #     # 电影封面的地址
        #     movie_img_url = movie.xpath('./div[@class="item"]/div[@class="pic"]/a/img/@src')[0]
        #     # print(movie_img_url)
            n += 1
            img += 1
            movie_list_info.append({
                'id': img,
                'name': name,
                'country': country,
                'year': year,
                'type': type,

                # 'movie_img_url': movie_img_url
            })
    for movie in movie_list_info:
        print(movie)
    #
    #     # 下载图片
    # for movie in movie_list_info:
    #     url = movie['movie_img_url']
    #     resp = requests.get(url)
    #     if resp.status_code == 200:
    #         img_name = '0000000{}.jpg'.format(movie['serial_number'])
    #         with open('./imgs/{}'.format(img_name), 'wb') as f:
    #             f.write(resp.content)


url = 'http://www.xicidaili.com/nn/'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36'
}
# ip_list = get_ip_list(url, headers=headers)
# proxies = get_random_ip(ip_list)
# print(proxies)
spider_douban_top250()