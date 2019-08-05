# Author：yangsen
# Email：2840278902@qq.com

import requests
import json
from matplotlib import pyplot as plt
from lxml import html
from wordcloud import WordCloud
import imageio
plt.rcParams["font.sans-serif"] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False

headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"}

url = 'https://www.acfun.cn/rest/pc-direct/rank/channel?channelId=&subChannelId=&rankLimit=30&rankPeriod=DAY'
proxy_info = {'host': 'web-proxy.oa.com', 'port': 8080}


response = requests.get(url, headers=headers,proxies=proxy_info)
# print(response.status_code)
html_data = response.text
# print(html_data)
selector = html.fromstring(html_data)


#  获取响应  json 字符串
data = response.content.decode()
# print(type(data))
#
# # 把json 字符串转化成  python类型
dict_data = json.loads(data)
# print(type(dict_data))
# print(dict_data)
#
# # 提取数据
tv_list = dict_data['rankList']
# print(tv_list)
# for i in tv_list:
#     print(i)
#
data_list = []
num = 1
# # 遍历
for tv in tv_list:
    temp = {}

    #id
    temp['id'] = num
    # 标题
    temp['title'] = tv['contentTitle']

    # up主?
    temp['userName'] = tv['userName']
    # 观看人数
    temp['viewCount'] = tv['viewCount']
    # 频道
    temp['channelName'] = tv['channelName']
    # 香蕉树
    temp['bananaCount'] = tv['bananaCount']
    # 封面图片链接
    temp['videoCover'] = tv['videoCover']
    # 贴ID
    temp['contentId'] = tv['contentId']
    # 粉丝数量
    temp['fansCount'] = tv['fansCount']


    # print(temp['contentId'])
    # 评论页数

#***
    detail_url = 'https://www.acfun.cn/rest/pc-direct/comment/listByFloor?sourceId={}&sourceType=3&page=1&pivotCommentId=0&newPivotCommentId=0&_ts=1564744654967'.format(temp['contentId'])
    # print(detail_url)
    resp = requests.get(detail_url, headers=headers, proxies=proxy_info)
    detail_data = resp.content.decode()
    # # 把json 字符串转化成  python类型
    dict_detail_data = json.loads(detail_data)
    # print(type(dict_detail_data))
    # print(type(dict_detail_data['totalPage']))
    temp_comment = []
    # # 评论
    for i in range(1,dict_detail_data['totalPage'] + 1):
        # print('i',i)
        content_url = 'https://www.acfun.cn/rest/pc-direct/comment/listByFloor?sourceId={}&sourceType=3&page={}&pivotCommentId=0&newPivotCommentId=0&_ts=1564744654967'.format(temp['contentId'],i)
        print(content_url)
        comment_resp = requests.get(content_url,headers=headers, proxies=proxy_info)
        comment_resp = comment_resp.content.decode()
        comment_data = json.loads(comment_resp)
        commentsMap = comment_data['commentsMap']
        # print(len(commentsMap))
        for dict_key in commentsMap.keys():
            # print(dict_key)
            comment = commentsMap[dict_key]['content']
            temp_comment.append(comment)
    temp['comment'] = temp_comment
    # 提取数据
    # tv_list = dict_detail_data['rankList']
    # print(tv_list)
    # print(detail_data)
#***


    data_list.append(temp)
    num += 1 # num为id，与网页中id无关，本地的

# 计算评论出现的次数，制作词云
com = {} # 暂存评论以及次数
for d in data_list:
    # print(d['comment'])
    for word in d['comment']:
        word = word.replace('emot','')
        word = word.replace('https', '')
        word = word.replace('ac', '')
        word = word.replace('img', '')
        word = word.replace('jpg', '')
        # 更新字典中的值
        # counts[word] = 取出字典中原来键对应的值 + 1
        # counts[word] = counts[word] + 1  # counts[word]如果没有就要报错
        # 字典。get（k） 如果字典中没有这个键 返回 NONE
        com[word] = com.get(word, 0) + 1

coms = list(com.items())
coms.sort(key=lambda x: x[1], reverse=True)
# print(coms)

c = [] #暂存评论，以个数的形式
for i in range(10):
    comm,num = coms[i]
    # c.append(comm)
    for _ in range(num):
        c.append(comm)

text = ' '.join(c)
WordCloud(
    font_path='msyh.ttc',
    background_color='white',
    width=800,
    height=600,
    # 相邻两个重复词之间的匹配
    collocations=False,
).generate(text).to_file('A站TOP10.png')

counts = {} #暂存频道与频道出现的次数
for word in data_list:
    word = word['channelName']
    counts[word] = counts.get(word,0) + 1

count = list(counts.items()) #转换成数列

couns = [] #暂存频道出现次数
channels = [] #暂存频道

user_name = [] #暂存前十up主名称
fans_count = [] #暂存前十up主粉丝数

data_list.sort(key=lambda x:x['fansCount'],reverse=True)
# print(items)

for i in range(10):
    user_name.append(data_list[i]['userName'])
    fans_count.append(data_list[i]['fansCount'])

# print(user_name,fans_count)

count.sort(key=lambda x:x[1],reverse=True)
len = len(count)

for i in range(len):
    channel,coun = count[i]
    channels.append(channel)
    couns.append(coun)
    # print(channel,coun) #频道与频道出现的次数


# 下载图片
for tv in  data_list:
    link = tv['videoCover']
    resp = requests.get(link)
    if resp.status_code == 200:
        with open('./imgs/{}.jpg'.format(tv['id']),'wb') as f:
            f.write(resp.content)

# 制作频道与出现次数饼图
explode = [0.1]
for i in range(len-1):
    explode.append(0)
# colors = ['red', 'purple','blue', 'yellow','gray','green','bl']
plt.pie(couns, shadow=True, explode=explode,labels=channels, autopct='%1.1f%%')
plt.legend(loc=2)
plt.axis('equal')
plt.show()

#制作up主与粉丝的柱状图
plt.ylabel('up主')
plt.xlabel('粉丝数量')
plt.barh(user_name, fans_count)
plt.show()

# 存储成json

f = open('Acfun.json','w', encoding='utf-8')
# 写入  ensure_ascii指定false
json.dump(data_list, f, ensure_ascii=False)



